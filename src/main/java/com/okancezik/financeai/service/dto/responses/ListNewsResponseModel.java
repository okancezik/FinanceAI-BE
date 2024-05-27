package com.okancezik.financeai.service.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListNewsResponseModel {
    private int id;
    private String url;
    private LocalDateTime loadDate;
}
