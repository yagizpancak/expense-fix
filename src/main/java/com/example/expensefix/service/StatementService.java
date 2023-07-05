package com.example.expensefix.service;


import com.example.expensefix.dto.CategoryRequest;
import com.example.expensefix.dto.MonthRequest;
import com.example.expensefix.dto.SignupRequest;
import com.example.expensefix.exception.GenericBadRequestException;
import com.example.expensefix.model.Expense;
import com.example.expensefix.model.Statement;
import com.example.expensefix.model.User;
import com.example.expensefix.repository.ExpenseRepository;
import com.example.expensefix.repository.StatementRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatementService {

    private final ExpenseRepository expenseRepository;
    private final StatementRepository statementRepository;

    public void saveExpense(int statementID, String date, String category, float amount) {
        Expense expense = new Expense();
        expense.setStatementID(statementID);
        expense.setDate(date);
        expense.setCategory(category);
        expense.setAmount(amount);
        expenseRepository.save(expense);
    }


    public Boolean upload(MultipartFile file, Integer id, String bankName) throws GenericBadRequestException {
        try {

            switch (bankName) {
                case "isbank":
                    HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
                    HSSFSheet sheet = workbook.getSheetAt(0);

                    Statement statement = new Statement();

                    String date = null;
                    for (int i=16; i<sheet.getPhysicalNumberOfRows(); i++){
                        HSSFRow row = sheet.getRow(i);

                        if (row == null){
                            break;
                        }else{
                            date = String.valueOf(row.getCell(0)).split("-")[0];
                            Float amount;
                            String category = String.valueOf(row.getCell(7));

                            String tAmount = String.valueOf(row.getCell(3));
                            if(tAmount.charAt(0) == '-'){
                                amount = Float.parseFloat(tAmount.substring(0));
                                saveExpense(statement.getId(),date,category,amount);

                            }else{
                                continue;
                            }
                        }
                    }
                    if(date != null) {
                        statement.setMonth(Month.of(Integer.parseInt(String.valueOf(date.charAt(3)) + String.valueOf(date.charAt(4)))).name());
                        statement.setUserID(id);
                        statement.setBankName(bankName);
                        statementRepository.save(statement);
                    }

                case "ziraatbank":
                    XSSFWorkbook workbook2 = new XSSFWorkbook(file.getInputStream());
                    XSSFSheet sheet2 = workbook2.getSheetAt(0);

                    Statement statement2 = new Statement();

                    String date2 = null;
                    for (int i=12; i<sheet2.getPhysicalNumberOfRows(); i++){
                        XSSFRow row = sheet2.getRow(i);
                        if (row == null){
                            break;
                        }else{

                            String[] tdate = String.valueOf(row.getCell(0)).split("\\.");
                            date2 = tdate[0] + '/' + tdate[1] + '/' + tdate[2];
                            Float amount;
                            String category = String.valueOf(row.getCell(2));

                            String tAmount = String.valueOf(row.getCell(3));
                            if(tAmount.charAt(0) == '-'){
                                amount = Float.parseFloat(tAmount.substring(0));
                                saveExpense(statement2.getId(),date2,category,amount);
                            }else{
                                continue;
                            }
                        }
                    }
                    if(date2 != null) {
                        statement2.setMonth(Month.of(Integer.parseInt(String.valueOf(date2.charAt(3)) + String.valueOf(date2.charAt(4)))).name());
                        statement2.setUserID(id);
                        statement2.setBankName(bankName);
                        statementRepository.save(statement2);
                    }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<Expense> getMonthlyStatementByCardNumberAndMonth(String cardNumber, String month){
        int statementID = statementRepository.findByCardNumberAndMonth(cardNumber,month).getId();
        return expenseRepository.findAllByStatementID(statementID);
    }

    public List<Statement> getAllStatementByUserId(int userID){
        return statementRepository.findByUserID(userID);
    }

    public MonthRequest lastMonthSpendings(int userdID){
        MonthRequest monthRequest = new MonthRequest("",0,new ArrayList<CategoryRequest>());
        float total = 0;
        List<CategoryRequest> categoryList;
        String lastMonth = statementRepository.findTopByUserIDOrderByIdDesc(userdID).getMonth();
        List<Statement> lastMonthStatements = statementRepository.findByUserIDAndMonth(userdID, lastMonth);

        List<String> categories = new ArrayList<>();
        List<Float> amounts = new ArrayList<>();

        for(Statement statement: lastMonthStatements){
            List<String> aStatementCategories = expenseRepository.findDistinctCategoryByStatementID(statement.getId());

            for(String category: aStatementCategories){
                float tempCategoryTotal = 0;
                for(Float amount: expenseRepository.findAmountByCategoryAndStatementID(category,statement.getId())){
                    tempCategoryTotal += amount;
                    total += amount;
                }

                if(!categories.contains(category)){
                    categories.add(category);
                    amounts.add(tempCategoryTotal);
                }else{
                    int index = categories.indexOf(category);
                    amounts.set(index, amounts.get(index) + tempCategoryTotal);
                }
            }
        }
        for(String category: categories){
            CategoryRequest categoryRequest = new CategoryRequest(category, amounts.get(categories.indexOf(category)));
            monthRequest.getCategoryList().add(categoryRequest);
        }

        monthRequest.setMonth(lastMonth);
        monthRequest.setTotal(total);

        return monthRequest;
    }
}
