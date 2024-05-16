package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.AIComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AICommentRepository extends JpaRepository<AIComment, Integer> {

    @Query("Select a from AIComment a where a.lot.id=:id ORDER BY a.loadDate DESC LIMIT 1")
    Optional<AIComment> findLastAIComment(int id);

}
