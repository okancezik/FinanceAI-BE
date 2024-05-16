package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.entity.concretes.AIComment;
import com.okancezik.financeai.service.dto.requests.AddAICommentRequestModel;
import com.okancezik.financeai.service.dto.responses.ListAICommentResponseModel;

public interface AICommentService {
    void add(AddAICommentRequestModel requestModel);

    ListAICommentResponseModel getLastComment(int id);
}
