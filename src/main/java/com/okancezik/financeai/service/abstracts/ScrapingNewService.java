package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.requests.AddScrapingNews;
import com.okancezik.financeai.service.dto.responses.ListScrapingNewsResponseModel;

import java.util.List;

public interface ScrapingNewService {
    boolean add(AddScrapingNews requestModel);

    List<ListScrapingNewsResponseModel> getScrapiedNews(int lotId);
}
