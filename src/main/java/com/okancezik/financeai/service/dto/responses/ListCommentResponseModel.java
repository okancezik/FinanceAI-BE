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
public class ListCommentResponseModel {
    private String comment;
    private LocalDateTime loadDate;
    private String lotCode;
}
