package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Integer> {
}
