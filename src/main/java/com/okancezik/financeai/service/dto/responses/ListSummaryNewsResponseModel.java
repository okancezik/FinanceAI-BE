package com.okancezik.financeai.service.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListSummaryNewsResponseModel {
    private String summary;
    private LocalDateTime loadDate;
}
