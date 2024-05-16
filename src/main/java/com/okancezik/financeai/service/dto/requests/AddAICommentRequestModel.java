package com.okancezik.financeai.service.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddAICommentRequestModel {

    @NotNull
    @NotBlank
    private int lotId;

    @NotNull
    @NotBlank
    private String comment;

    private LocalDateTime loadDate = LocalDateTime.now();

}
