package com.okancezik.financeai.service.dto.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddNewsRequestModel {

    @NotNull
    @NotBlank
    private String url;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private int lotId;
}
