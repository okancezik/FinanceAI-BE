package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.DataResult;
import com.okancezik.financeai.core.utils.results.SuccessDataResult;
import com.okancezik.financeai.service.abstracts.CommentService;
import com.okancezik.financeai.service.dto.responses.ListCommentResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentsApi {

    private final CommentService service;

    @GetMapping("/lot/{id}")
    public DataResult<List<ListCommentResponseModel>> getAllCommentsByLot(@PathVariable int id){
        var data = this.service.getAllCommentsByLot(id);
        return new SuccessDataResult<>(data,"Listed comments");
    }
}
