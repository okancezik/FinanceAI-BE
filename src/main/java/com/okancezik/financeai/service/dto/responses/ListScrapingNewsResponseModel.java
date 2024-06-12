package com.okancezik.financeai.service.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListScrapingNewsResponseModel {
    private int newsId;
    private String scraped;
}
