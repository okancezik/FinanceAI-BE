package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.*;
import com.okancezik.financeai.service.abstracts.TargetService;
import com.okancezik.financeai.service.dto.requests.AddTargetRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/target")
public class TargetsApi {

    private final TargetService targetService;

    @PostMapping
    public Result add(@RequestBody AddTargetRequestModel requestModel){
        var result = this.targetService.add(requestModel);
        return result.isSuccess()
                ? new SuccessResult(result.getMessage())
                : new ErrorResult(result.getMessage());

    }

    @GetMapping("/{id}")
    public DataResult getUserTarget(@PathVariable int id){
        var data = this.targetService.getTargetByUserId(id);
        if(data==null){
            return new ErrorDataResult("Not found user's target");
        }
        return new SuccessDataResult(data,"Listed user's target");
    }
}
