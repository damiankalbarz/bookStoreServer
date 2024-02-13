package com.example.bookstore.service;

import com.example.bookstore.models.Book;
import com.example.bookstore.models.User;
import com.example.bookstore.models.UserBook;
import com.example.bookstore.repository.UserBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBookService {

    @Autowired
    private UserBookRepository userBookRepository;

    public void assignBookToUser(User user, Book book) {
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);
        userBookRepository.save(userBook);
    }

    // Dodaj inne metody serwisu według potrzeb
}
