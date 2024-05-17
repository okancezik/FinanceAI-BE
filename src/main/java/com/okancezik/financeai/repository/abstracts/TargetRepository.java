package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TargetRepository extends JpaRepository<Target,Integer> {

    @Query("Select t from Target t where t.user.id=:id ORDER BY t.loadDate DESC LIMIT 1")
    Optional<Target> findLastTarget(int id);
}
