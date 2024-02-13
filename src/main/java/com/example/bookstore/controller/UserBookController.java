package com.example.bookstore.controller;

import com.example.bookstore.models.Book;
import com.example.bookstore.models.User;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.UserBookService;
import com.example.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-books")
public class UserBookController {

    @Autowired
    private UserBookService userBookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @PostMapping("/assign-book")
    public ResponseEntity<String> assignBookToUser(@RequestParam Integer userId, @RequestParam int bookId) {
        User user = userService.getUserById(userId);
        Book book = bookService.getBookById(bookId);

        if (user != null && book != null) {
            userBookService.assignBookToUser(user, book);
            return ResponseEntity.ok("Book assigned to user successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid user or book");
        }
    }

    // Dodaj inne metody kontrolera według potrzeb
}
