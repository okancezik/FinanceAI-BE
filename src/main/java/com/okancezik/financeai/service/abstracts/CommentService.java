package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.requests.AddCommentRequestModel;
import com.okancezik.financeai.service.dto.responses.ListCommentResponseModel;

import java.util.List;

public interface CommentService {
    List<ListCommentResponseModel> getAllCommentsByLot(int id);
    void add(AddCommentRequestModel request);
}
