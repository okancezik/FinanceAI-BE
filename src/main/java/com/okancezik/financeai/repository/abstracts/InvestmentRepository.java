package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment,Integer> {

    List<Investment> findByUserId(int id);
}
