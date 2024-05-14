package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotRepository extends JpaRepository<Lot,Integer> {
}
