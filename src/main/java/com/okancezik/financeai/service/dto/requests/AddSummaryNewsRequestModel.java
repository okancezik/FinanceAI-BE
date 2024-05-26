package com.okancezik.financeai.service.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddSummaryNewsRequestModel {

    @NotBlank
    @NotNull
    private String summary;

    @NotBlank
    @NotNull
    private int newsId;
}
