package com.example.bookstore.books.repository;

import com.example.bookstore.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByTitle(String title);
}
