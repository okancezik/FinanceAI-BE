package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.requests.AddNewsRequestModel;
import com.okancezik.financeai.service.dto.responses.ListNewsResponseModel;

import java.util.List;

public interface NewsService {

    void add(AddNewsRequestModel requestModel);

    List<ListNewsResponseModel> findAll();
}
