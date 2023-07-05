package com.example.expensefix.controller;


import com.example.expensefix.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statement")
public class StatementController {

    private final StatementService statementService;
    @PostMapping(value = "/upload")
    public Boolean upload(@RequestBody MultipartFile file)
    { return statementService.upload(file); }

}
