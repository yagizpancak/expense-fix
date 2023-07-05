package com.example.expensefix.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class StatementRequest {
    String userID;
    String bankName;
    MultipartFile file;
}
