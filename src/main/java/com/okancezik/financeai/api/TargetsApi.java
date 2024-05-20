package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.*;
import com.okancezik.financeai.service.abstracts.TargetService;
import com.okancezik.financeai.service.dto.requests.AddTargetRequestModel;
import com.okancezik.financeai.service.dto.requests.UpdateTargetRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
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
        if(data == null){
            return new SuccessDataResult("Not found user's target");
        }
        return new SuccessDataResult(data,"Listed user's target");
    }

    @PutMapping
    public Result update(@RequestBody UpdateTargetRequestModel requestModel){
        return this.targetService.update(requestModel);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.targetService.delete(id);
    }
}
