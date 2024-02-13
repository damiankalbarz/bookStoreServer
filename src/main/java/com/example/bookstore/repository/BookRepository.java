package com.example.bookstore.repository;

import com.example.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByTitle(String title);
}
