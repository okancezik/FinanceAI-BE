package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.requests.AddInvestmentRequestModel;
import com.okancezik.financeai.service.dto.responses.ListUserInvestmentsResponseModel;

import java.util.List;

public interface InvestmentService {
    boolean add(AddInvestmentRequestModel requestModel);

    List<ListUserInvestmentsResponseModel> getUserInvestments(int id);
}
