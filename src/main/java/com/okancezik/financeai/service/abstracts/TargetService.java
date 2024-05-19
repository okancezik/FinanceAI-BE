package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.core.utils.results.Result;
import com.okancezik.financeai.service.dto.requests.AddTargetRequestModel;
import com.okancezik.financeai.service.dto.requests.UpdateTargetRequestModel;
import com.okancezik.financeai.service.dto.responses.ListUserTargetResponseModel;

public interface TargetService {
    Result add(AddTargetRequestModel requestModel);
    Result update(UpdateTargetRequestModel requestModel);
    Result delete(int id);
    ListUserTargetResponseModel getTargetByUserId(int id);
}
