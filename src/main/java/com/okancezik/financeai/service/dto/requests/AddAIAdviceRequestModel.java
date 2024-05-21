package com.okancezik.financeai.service.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAIAdviceRequestModel {
    @NotNull
    @NotBlank
    private String advice;

    private LocalDateTime loadDate = LocalDateTime.now();

    @NotBlank
    @NotNull
    private int userId;
}
