package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.*;
import com.okancezik.financeai.service.abstracts.AICommentService;
import com.okancezik.financeai.service.dto.requests.AddAICommentRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ai-comments")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class AICommentsApi {

    private final AICommentService service;

    @PostMapping
    public Result add(@RequestBody AddAICommentRequestModel requestModel){
        this.service.add(requestModel);
        return new SuccessResult("Added ai comment to db");
    }

    @GetMapping("/{id}")
    public DataResult getLastComment(@PathVariable int id){
        var data = this.service.getLastComment(id);
        return data==null? new ErrorDataResult("Not found comment"): new SuccessDataResult(data,"Listed comment");
    }
}
