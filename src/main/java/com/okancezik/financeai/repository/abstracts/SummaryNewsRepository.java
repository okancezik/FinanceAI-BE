package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.SummaryNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SummaryNewsRepository extends JpaRepository<SummaryNew,Integer> {

    List<SummaryNew> findByNewsId(int id);

    @Query("Select sn from SummaryNew sn where sn.news.id=:id ORDER BY sn.loadDate DESC LIMIT 1")
    SummaryNew findLastSummary(int id);
}
