package com.okancezik.financeai.repository.abstracts;

import com.okancezik.financeai.entity.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findByLotId(int id);

}
