package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.entity.concretes.AIAdvice;
import com.okancezik.financeai.repository.abstracts.AIAdviceRepository;
import com.okancezik.financeai.service.abstracts.AIAdviceService;
import com.okancezik.financeai.service.dto.requests.AddAIAdviceRequestModel;
import com.okancezik.financeai.service.dto.responses.ListAIAdviceResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AIAdviceManager implements AIAdviceService {

    private final AIAdviceRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public void add(AddAIAdviceRequestModel requestModel) {
        var data = this.mapperService.forRequest().map(requestModel, AIAdvice.class);
        this.repository.save(data);
    }

    @Override
    public List<ListAIAdviceResponseModel> getAdvicesByUserId(int id) {
        var data = this.repository.findByUserId(id);
        if (!data.isEmpty()){
           var advices = data.stream()
                   .map(x->this.mapperService.forResponse().map(x,ListAIAdviceResponseModel.class))
                   .collect(Collectors.toList());
            return advices;
        }
        return null;
    }
}
