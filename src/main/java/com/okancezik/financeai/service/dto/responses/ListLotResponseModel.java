package com.okancezik.financeai.service.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListLotResponseModel {
    private String code;
    private double value;
    private String company;
}
