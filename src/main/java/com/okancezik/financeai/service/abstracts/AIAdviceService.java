package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.requests.AddAIAdviceRequestModel;
import com.okancezik.financeai.service.dto.responses.ListAIAdviceResponseModel;

import java.util.List;

public interface AIAdviceService {
    void add(AddAIAdviceRequestModel requestModel);

    void multipleAdd(List<AddAIAdviceRequestModel> requestModels);
    List<ListAIAdviceResponseModel> getAdvicesByUserId(int id);
}
