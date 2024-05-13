package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {

    List<Expense> findByUserId(int userId);
}
