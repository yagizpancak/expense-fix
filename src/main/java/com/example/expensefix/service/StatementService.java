package com.example.expensefix.service;


import com.example.expensefix.exception.GenericBadRequestException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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




    public Boolean upload(MultipartFile file) throws GenericBadRequestException {
        String bankName = "isbank";
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            HSSFSheet sheet = workbook.getSheetAt(0);
            switch (bankName) {
                case "isbank":
                    for (int i=16; i<sheet.getPhysicalNumberOfRows(); i++){
                        HSSFRow row = sheet.getRow(i);

                        if (row == null){
                            break;
                        }else{
                            String date = String.valueOf(row.getCell(0));
                            Float amount;
                            String type = String.valueOf(row.getCell(7));

                            String tAmount = String.valueOf(row.getCell(3));
                            if(tAmount.charAt(0) == '-'){
                                amount = Float.parseFloat(tAmount.substring(0));
                                System.out.println(date + ' ' + type + ' ' + amount);
                            }else{
                                continue;
                            }
                        }

                    }
                case "ziraatbank":
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

    }
}
