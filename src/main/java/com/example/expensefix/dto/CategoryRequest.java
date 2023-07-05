package com.example.expensefix.dto;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class CategoryRequest {
    String name;
    Float amount;

}
