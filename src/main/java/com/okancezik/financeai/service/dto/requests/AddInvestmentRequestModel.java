package com.okancezik.financeai.service.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddInvestmentRequestModel {

    @NotNull
    @NotBlank
    private int amount;

    @NotNull
    @NotBlank
    private int lotId;

    @NotNull
    @NotBlank
    private int userId;
}
