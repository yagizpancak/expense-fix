package com.example.expensefix.controller;


import com.example.expensefix.service.StatementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statement")
public class StatementController {

    private final StatementService statementService;

    @PostMapping("/upload")
    public Boolean upload(
            @Valid @RequestParam Integer userID,
            @Valid @RequestParam MultipartFile file,
            @Valid @RequestParam String bankName
            )
    { return statementService.upload(userID, file, bankName); }

}
