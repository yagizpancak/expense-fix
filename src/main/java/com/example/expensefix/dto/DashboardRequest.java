package com.example.expensefix.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DashboardRequest {
    MonthRequest lastMonth;
    List<MonthRequest> monthly;

}
