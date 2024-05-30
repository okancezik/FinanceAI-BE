package com.okancezik.financeai.service.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListUserInvestmentsResponseModel {

    private int amount;
    private int userId;
    private int lotId;
    private String lotCode;
    private String lotCompany;
    private double value;
}
