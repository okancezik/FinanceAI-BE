package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.DataResult;
import com.okancezik.financeai.core.utils.results.Result;
import com.okancezik.financeai.core.utils.results.SuccessDataResult;
import com.okancezik.financeai.core.utils.results.SuccessResult;
import com.okancezik.financeai.service.abstracts.NewsService;
import com.okancezik.financeai.service.dto.requests.AddNewsRequestModel;
import com.okancezik.financeai.service.dto.responses.ListNewsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class NewsApi {

    private final NewsService service;

    @PostMapping
    public Result add(@RequestBody AddNewsRequestModel requestModel){
        this.service.add(requestModel);
        return new SuccessResult("Added news");
    }

    @GetMapping("/{id}")
    public DataResult<List<ListNewsResponseModel>> getAllByLotId(@PathVariable int id){
        var data = this.service.getAllByLotId(id);
        return new SuccessDataResult<>(data,"Listed news for lot");
    }


    //@PostMapping("/scrap-add")
    //public Result addScrapingNew(){
    //}
}
