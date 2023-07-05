package com.example.expensefix.service;


import com.example.expensefix.exception.GenericBadRequestException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StatementService {




    public Boolean upload(Integer userID, MultipartFile file, String bankName) throws GenericBadRequestException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);

            switch (bankName) {
                case "isbank":
                    for (int i=16; i<sheet.getPhysicalNumberOfRows(); i++){
                        XSSFRow row = sheet.getRow(i);
                        if (row.getCell(0).getCellType() == CellType.BLANK){
                            break;
                        }else{
                            String date = String.valueOf(row.getCell(1));
                            float amount;
                            String type = String.valueOf(row.getCell(8));

                            String tAmount = String.valueOf(row.getCell(4));
                            if(tAmount.charAt(0) == '-'){
                                amount = Float.parseFloat(tAmount.substring(0));
                                System.out.println(date + ' ' + amount + ' ' + type);
                            }else{
                                continue;
                            }
                        }
                    }

                case "ziraatbank":
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new GenericBadRequestException("Error on Statement Reader. Make sure the bank name " + bankName);

        }
        return true;

    }
}
