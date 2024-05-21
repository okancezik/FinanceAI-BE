package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.AIAdvice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AIAdviceRepository extends JpaRepository<AIAdvice,Integer> {
    List<AIAdvice> findByUserId(int id);
}
