package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.entity.concretes.Investment;
import com.okancezik.financeai.repository.abstracts.InvestmentRepository;
import com.okancezik.financeai.service.abstracts.InvestmentService;
import com.okancezik.financeai.service.dto.requests.AddInvestmentRequestModel;
import com.okancezik.financeai.service.dto.responses.ListUserInvestmentsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvestmentManager implements InvestmentService {

    private final InvestmentRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public boolean add(AddInvestmentRequestModel requestModel) {
        var data = this.mapperService.forRequest().map(requestModel, Investment.class);
        try {
            this.repository.save(data);
            return true;
        }catch (Exception err){
            return false;
        }

    }

    @Override
    public List<ListUserInvestmentsResponseModel> getUserInvestments(int id) {
        var data = this.repository.findByUserId(id);
        if(!data.isEmpty()){
            var investments = data.stream().map(x->this.mapperService.forResponse()
                                    .map(x, ListUserInvestmentsResponseModel.class))
                                    .collect(Collectors.toList());
            return investments;
        }
        return null;
    }
}
