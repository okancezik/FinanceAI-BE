package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Integer> {

    List<News> findByLotId(int id);
}
