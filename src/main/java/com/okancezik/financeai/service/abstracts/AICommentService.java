package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.requests.AddAICommentRequestModel;

public interface AICommentService {
    void add(AddAICommentRequestModel requestModel);
}
