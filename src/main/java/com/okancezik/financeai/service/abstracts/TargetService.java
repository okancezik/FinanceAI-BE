package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.core.utils.results.Result;
import com.okancezik.financeai.service.dto.requests.AddTargetRequestModel;
import com.okancezik.financeai.service.dto.responses.ListUserTargetResponseModel;

public interface TargetService {
    Result add(AddTargetRequestModel requestModel);
    ListUserTargetResponseModel getTargetByUserId(int id);
}
