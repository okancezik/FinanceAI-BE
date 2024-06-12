package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.ScrapingNew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScrapingNewRepository extends JpaRepository<ScrapingNew,Integer> {
    List<ScrapingNew> findByNews_LotId(int id);
}
