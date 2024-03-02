package com.example.bookstore.books.controller;

import com.example.bookstore.books.models.Book;
import com.example.bookstore.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin
@RestController
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return service.saveBook(book);
    }

    @PostMapping("/addBooks")
    public List<Book> saveBooks(@RequestBody List<Book> books){
        return service.saveBooks(books);
    }

    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return service.getBooks();
    }

    @GetMapping("/book/{id}")
    public Book findBookById(@PathVariable int id){
        return service.getBookById(id);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable int id){
        return service.deleteBook(id);
    }

    @PutMapping("/update")
    public Book updateBook(Book book){
        return service.updateBook(book);
    }

    @PostMapping("/likeBook/{id}")
    public void incrementLikeCount(@PathVariable int id){
        service.incrementLikeCount(id);
    }

    @PostMapping("/hateBook/{id}")
    public void hateBook(@PathVariable int id){
        service.incrementHateBook(id);
    }

    @PutMapping("/addComment/{id}")
    public ResponseEntity<Book> addComment(@PathVariable int id, @RequestBody String comment){
        Book updatedBook = service.addComment(id, comment);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }



}
