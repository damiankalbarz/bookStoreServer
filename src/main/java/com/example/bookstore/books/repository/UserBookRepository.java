package com.example.bookstore.books.repository;

import com.example.bookstore.books.models.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookRepository extends JpaRepository<UserBook, Integer> {

}
