package com.example.expensefix.controller;


import com.example.expensefix.service.StatementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statement")
public class StatementController {

    private final StatementService statementService;

    @PostMapping("/upload")
    public Boolean upload(
            @Valid @RequestBody Integer userID,
            @Valid @RequestBody MultipartFile file,
            @Valid @RequestBody String bankName
            )
    { return statementService.upload(userID, file, bankName); }

}
