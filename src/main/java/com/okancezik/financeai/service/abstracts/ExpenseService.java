package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.responses.ListExpenseResponseModel;

import java.util.List;

public interface ExpenseService {
    List<ListExpenseResponseModel> getAllExpensesByUser(int id);
}
