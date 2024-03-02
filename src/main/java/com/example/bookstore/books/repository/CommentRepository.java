package com.example.bookstore.books.repository;

import com.example.bookstore.books.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByBookId(Long bookId);
}
