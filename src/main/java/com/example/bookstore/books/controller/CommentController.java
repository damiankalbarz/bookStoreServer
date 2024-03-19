package com.example.bookstore.books.controller;

import com.example.bookstore.books.models.Comment;
import com.example.bookstore.books.service.CommentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestParam int bookId, @RequestParam String content) {
        Comment addedComment = commentService.addComment(bookId, content);
        return new ResponseEntity<>(addedComment, HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> allComments = commentService.getAllComments();
        return new ResponseEntity<>(allComments, HttpStatus.OK);
    }

    @GetMapping("/byBook/{bookId}")
    public ResponseEntity<List<Comment>> getCommentsByBookId(@PathVariable Long bookId) {
        List<Comment> comments = commentService.getCommentsByBookId(bookId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("like/{commentId}")
    public ResponseEntity<Comment> likeComment(@PathVariable Long commentId){
        Comment comment = commentService.incrementLikeCount(commentId);
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }

    @PostMapping("hate/{commentId}")
    public ResponseEntity<Comment> hateComment(@PathVariable Long commentId){
        Comment comment = commentService.incrementHateCount(commentId);
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }




}
