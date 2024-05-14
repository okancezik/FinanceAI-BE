package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.DataResult;
import com.okancezik.financeai.core.utils.results.SuccessDataResult;
import com.okancezik.financeai.service.abstracts.LotService;
import com.okancezik.financeai.service.dto.responses.ListLotResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lot")
public class LotsApi {

    private final LotService service;

    @GetMapping
    public DataResult<List<ListLotResponseModel>> getAll(){
        var data = this.service.getAllLot();
        return new SuccessDataResult<>(data,"Listed all lots");
    }
}
