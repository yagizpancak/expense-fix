package com.example.expensefix.dto;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class MonthRequest {
    String month;
    float total;
    List<CategoryRequest> categoryList;

}
