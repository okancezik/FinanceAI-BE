package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.DataResult;
import com.okancezik.financeai.core.utils.results.ErrorDataResult;
import com.okancezik.financeai.core.utils.results.SuccessDataResult;
import com.okancezik.financeai.service.abstracts.LotService;
import com.okancezik.financeai.service.dto.responses.ListLotResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lot")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class LotsApi {

    private final LotService service;

    @GetMapping
    public DataResult<List<ListLotResponseModel>> getAll(){
        var data = this.service.getAllLot();
        return new SuccessDataResult<>(data,"Listed all lots");
    }


    @GetMapping("/{id}")
    public DataResult<ListLotResponseModel> getLotDetail(@PathVariable int id){
        var data = this.service.getLotDetail(id);
        if (data != null){
            return new SuccessDataResult<>(data,"Listed all lots");
        }else{
            return new ErrorDataResult<>("Not found lot");
        }

    }
}
