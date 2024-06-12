package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.*;
import com.okancezik.financeai.service.abstracts.ScrapingNewService;
import com.okancezik.financeai.service.dto.requests.AddScrapingNews;
import com.okancezik.financeai.service.dto.responses.ListScrapingNewsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/scraping-new")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class ScrapingNewApi {
    private final ScrapingNewService service;

    @PostMapping
    public Result add(@RequestBody AddScrapingNews request){
        var result = this.service.add(request);
        return result
                ? new SuccessResult("Added scraped news")
                : new ErrorResult("Failed add operation");
    }

    @GetMapping("{id}")
    public DataResult<List<ListScrapingNewsResponseModel>> getAll(@PathVariable int id){
        var result = this.service.getScrapiedNews(id);
        if(result == null){
            return new ErrorDataResult<>("Fail");
        }
        return new SuccessDataResult<>(result,"listed scraped news for this lot");
    }
}
