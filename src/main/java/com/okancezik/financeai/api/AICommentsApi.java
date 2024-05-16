package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.SuccessResult;
import com.okancezik.financeai.service.abstracts.AICommentService;
import com.okancezik.financeai.service.dto.requests.AddAICommentRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ai-comments")
public class AICommentsApi {

    private final AICommentService service;

    @PostMapping
    public SuccessResult add(@RequestBody AddAICommentRequestModel requestModel){
        this.service.add(requestModel);
        return new SuccessResult("Added ai comment to db");
    }
}
