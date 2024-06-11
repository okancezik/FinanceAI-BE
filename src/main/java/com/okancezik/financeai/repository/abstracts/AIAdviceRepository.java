package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.AIAdvice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AIAdviceRepository extends JpaRepository<AIAdvice,Integer> {

    @Query("Select a from AIAdvice a where a.user.id=:id ORDER BY a.loadDate DESC LIMIT 5")
    List<AIAdvice> findByUserId(int id);
}
