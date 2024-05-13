package com.okancezik.financeai.service.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListExpenseResponseModel {
    private String category;
    private String description;
    private double amount;
    private String location;
    private LocalDateTime loadDate;
    private int userId;
}
