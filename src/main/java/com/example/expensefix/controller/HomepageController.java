package com.example.expensefix.controller;

import com.example.expensefix.dto.DashboardRequest;
import com.example.expensefix.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomepageController {

    private final StatementService statementService;

    @GetMapping("/Homepage")
    public DashboardRequest dashboard(int userdID){
        return statementService.DashboardSpendings(userdID);
    }
}
