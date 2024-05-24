package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.Result;
import com.okancezik.financeai.core.utils.results.SuccessResult;
import com.okancezik.financeai.service.abstracts.NewsService;
import com.okancezik.financeai.service.dto.requests.AddNewsRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
public class NewsApi {

    private final NewsService service;

    @PostMapping
    public Result add(@RequestBody AddNewsRequestModel requestModel){
        this.service.add(requestModel);
        return new SuccessResult("Added news");
    }
}
