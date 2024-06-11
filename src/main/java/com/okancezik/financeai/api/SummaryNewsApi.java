package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.*;
import com.okancezik.financeai.service.abstracts.SummaryNewsService;
import com.okancezik.financeai.service.dto.requests.AddSummaryNewsRequestModel;
import com.okancezik.financeai.service.dto.responses.ListSummaryNewsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/summary-news")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class SummaryNewsApi {

    private final SummaryNewsService service;

    @PostMapping
    public Result add(@RequestBody AddSummaryNewsRequestModel requestModel){
        var data = this.service.add(requestModel);
        if(data){
            return new SuccessResult("Added summary");
        }else{
            return new ErrorResult("Add operation fail");
        }
    }

    @GetMapping("/{id}")
    public DataResult<List<ListSummaryNewsResponseModel>> getSummariesByNewsId(@PathVariable int id){
        var data = this.service.getSummariesByNewsId(id);
        return new SuccessDataResult<>(data,"Listed summary");
    }

    @GetMapping("/last/{id}")
    public DataResult<ListSummaryNewsResponseModel> getLastSummaryNew(@PathVariable int id){
        var data = this.service.getLastSummaryNew(id);
        return new SuccessDataResult<>(data,"Listed summary");
    }
}
