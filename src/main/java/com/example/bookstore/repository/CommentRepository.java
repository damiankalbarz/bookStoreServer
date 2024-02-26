package com.example.bookstore.repository;

import com.example.bookstore.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByBookId(Long bookId);
}
