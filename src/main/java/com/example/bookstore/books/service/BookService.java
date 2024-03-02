package com.example.bookstore.books.service;

import com.example.bookstore.books.repository.BookRepository;
import com.example.bookstore.books.models.Book;
import com.example.bookstore.books.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public Book saveBook(Book book){
        return repository.save(book);
    }

    public List<Book> saveBooks(List<Book> books){
        return repository.saveAll(books);
    }

    public List<Book> getBooks(){
        return repository.findAll();
    }

    public Book getBookById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public Book getBookByTitle(String title){
        return repository.findByTitle(title);
    }

    public String deleteBook(int id){
        repository.deleteById(id);
        return "Book removed "+id;
    }
    public Book updateBook(Book book){
        Book exitingBook = repository.findById(book.getId()).orElse(null);
        assert exitingBook != null;
        exitingBook.setTitle(book.getTitle());
        exitingBook.setAuthor(book.getAuthor());
        exitingBook.setDescription(book.getDescription());
        exitingBook.setPrice(book.getPrice());
        return repository.save(exitingBook);
    }
    public void incrementLikeCount(int id){
        Book exitingBook = repository.findById(id).orElse(null);
        assert exitingBook != null;
        exitingBook.setLikeCount(exitingBook.getLikeCount()+1);
        repository.save(exitingBook);
    }
    public void incrementHateBook(int id){
        Book exitingBook = repository.findById(id).orElse(null);
        assert exitingBook != null;
        exitingBook.setHateCount(exitingBook.getHateCount()+1);
        repository.save(exitingBook);
    }

    public Book addComment(Integer id, String commentText) {
        Book existingBook = repository.findById(id).orElseThrow(() -> new RuntimeException("Książka o identyfikatorze: " + id + " nie została znaleziona"));
        Comment comment = new Comment();
        comment.setText(commentText);
        existingBook.addComments(comment);
        return repository.save(existingBook);
    }
}
