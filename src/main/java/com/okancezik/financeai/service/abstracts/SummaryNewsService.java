package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.requests.AddSummaryNewsRequestModel;
import com.okancezik.financeai.service.dto.responses.ListSummaryNewsResponseModel;

import java.util.List;

public interface SummaryNewsService {
    boolean add(AddSummaryNewsRequestModel requestModel);

    List<ListSummaryNewsResponseModel> getSummariesByNewsId(int newsId);

    ListSummaryNewsResponseModel getLastSummaryNew(int newsId);

}
