package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.*;
import com.okancezik.financeai.service.abstracts.AIAdviceService;
import com.okancezik.financeai.service.dto.requests.AddAIAdviceRequestModel;
import com.okancezik.financeai.service.dto.responses.ListAIAdviceResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/advices")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class AIAdvicesApi {

    private final AIAdviceService service;

    @PostMapping
    public Result add(@RequestBody AddAIAdviceRequestModel requestModel){
        this.service.add(requestModel);
        return new SuccessResult("Added advice");
    }

    @PostMapping("/multiple")
    public Result add(@RequestBody List<AddAIAdviceRequestModel> requestModels){
        this.service.multipleAdd(requestModels);
        return new SuccessResult("Added advice");
    }

    @GetMapping("/{id}")
    public DataResult<List<ListAIAdviceResponseModel>> getAdvicesByUserId(@PathVariable int id){
        var data = this.service.getAdvicesByUserId(id);
        return new SuccessDataResult<>(data,"Listed advices for this user");
    }

}
