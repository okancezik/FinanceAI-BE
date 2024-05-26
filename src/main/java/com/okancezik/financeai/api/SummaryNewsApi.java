package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.DataResult;
import com.okancezik.financeai.core.utils.results.Result;
import com.okancezik.financeai.core.utils.results.SuccessDataResult;
import com.okancezik.financeai.core.utils.results.SuccessResult;
import com.okancezik.financeai.service.abstracts.SummaryNewsService;
import com.okancezik.financeai.service.dto.requests.AddSummaryNewsRequestModel;
import com.okancezik.financeai.service.dto.responses.ListSummaryNewsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/summary-news")
@RequiredArgsConstructor
public class SummaryNewsApi {

    private final SummaryNewsService service;

    @PostMapping
    public Result add(@RequestBody AddSummaryNewsRequestModel requestModel){
        this.service.add(requestModel);
        return new SuccessResult("Added summary");
    }

    @GetMapping("/{id}")
    public DataResult<ListSummaryNewsResponseModel> getLastSummaryNew(@PathVariable int id){
        var data = this.service.getLastSummaryNew(id);
        return new SuccessDataResult<>(data,"Listed summary");
    }
}
