package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.repository.abstracts.ExpenseRepository;
import com.okancezik.financeai.service.abstracts.ExpenseService;
import com.okancezik.financeai.service.dto.responses.ListExpenseResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseManager implements ExpenseService {

    private final ExpenseRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public List<ListExpenseResponseModel> getAllExpensesByUser(int id) {
        var data = this.repository.findByUserId(id);
        return data.stream().map(x -> this.mapperService.forResponse()
                .map(x,ListExpenseResponseModel.class)).collect(Collectors.toList());
    }
}
