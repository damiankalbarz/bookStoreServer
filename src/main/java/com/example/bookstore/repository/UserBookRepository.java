package com.example.bookstore.repository;

import com.example.bookstore.models.User;
import com.example.bookstore.models.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookRepository extends JpaRepository<UserBook, Integer> {

}
