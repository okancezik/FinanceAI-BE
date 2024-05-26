package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.requests.AddSummaryNewsRequestModel;
import com.okancezik.financeai.service.dto.responses.ListSummaryNewsResponseModel;

public interface SummaryNewsService {
    void add(AddSummaryNewsRequestModel requestModel);

    ListSummaryNewsResponseModel getLastSummaryNew(int newsId);
}
