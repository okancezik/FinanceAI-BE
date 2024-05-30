package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.*;
import com.okancezik.financeai.service.abstracts.InvestmentService;
import com.okancezik.financeai.service.dto.requests.AddInvestmentRequestModel;
import com.okancezik.financeai.service.dto.responses.ListUserInvestmentsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/investments")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")

public class InvestmentsApi {

    private final InvestmentService service;

    @PostMapping
    public Result add(@RequestBody AddInvestmentRequestModel requestModel){
        var data = this.service.add(requestModel);
        return data ? new SuccessResult("Added investment") : new ErrorResult("Failed operation");
    }

    @GetMapping("/{id}")
    public DataResult<List<ListUserInvestmentsResponseModel>> getUserInvestments(@PathVariable int id){
        var data = this.service.getUserInvestments(id);
        if (data != null){
            return new SuccessDataResult<>(data,"Listed user's investmens");
        }
        return new ErrorDataResult<>(data,"Not found investment");
    }
}
