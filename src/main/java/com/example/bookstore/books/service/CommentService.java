package com.example.bookstore.books.service;

import com.example.bookstore.books.models.Book;
import com.example.bookstore.books.models.Comment;
import com.example.bookstore.books.repository.BookRepository;
import com.example.bookstore.books.repository.CommentRepository;
import com.example.bookstore.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment addComment(int bookId, String content) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));



        Comment comment = new Comment();
        comment.setBook(book);
        //comment.setUser(user);
        comment.setText(content);


        return commentRepository.save(comment);
    }

       public List<Comment> getCommentsByBookId(Long bookId) {
        return commentRepository.findByBookId(bookId);
    }

    public Comment incrementLikeCount(Long id){
        Comment exitingComment = commentRepository.findById(id).orElse(null);
        assert exitingComment != null;
        exitingComment.addLike();
        return commentRepository.save(exitingComment);
    }

    public Comment incrementHateCount(Long id){
        Comment exitingComment = commentRepository.findById(id).orElse(null);
        assert exitingComment != null;
        exitingComment.addHate();
        return commentRepository.save(exitingComment);


    }




}
