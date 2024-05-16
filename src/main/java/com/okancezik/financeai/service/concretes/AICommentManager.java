package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.core.utils.results.SuccessResult;
import com.okancezik.financeai.entity.concretes.AIComment;
import com.okancezik.financeai.repository.abstracts.AICommentRepository;
import com.okancezik.financeai.service.abstracts.AICommentService;
import com.okancezik.financeai.service.dto.requests.AddAICommentRequestModel;
import com.okancezik.financeai.service.dto.responses.ListAICommentResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AICommentManager implements AICommentService {

    private final AICommentRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public void add(AddAICommentRequestModel requestModel) {
        var aiComment = this.mapperService.forRequest().map(requestModel,
                AIComment.class);
        this.repository.save(aiComment);
    }

    @Override
    public ListAICommentResponseModel getLastComment(int id) {
        var data = this.repository.findLastAIComment(id);
        if(data.isPresent()){
            var comment = this.mapperService.forResponse().map(data.get(), ListAICommentResponseModel.class);
            return comment;
        }
        return null;
    }
}
