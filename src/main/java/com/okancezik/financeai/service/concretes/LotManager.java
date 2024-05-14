package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.repository.abstracts.LotRepository;
import com.okancezik.financeai.service.abstracts.LotService;
import com.okancezik.financeai.service.dto.responses.ListLotResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LotManager implements LotService {

    private final LotRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public List<ListLotResponseModel> getAllLot() {
       var data = this.repository.findAll();
       return data.stream().map(x->
               this.mapperService.forResponse().map(x, ListLotResponseModel.class))
               .collect(Collectors.toList());
    }
}
