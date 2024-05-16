package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.AIComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AICommentRepository extends JpaRepository<AIComment, Integer> {
}
