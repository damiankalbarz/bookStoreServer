package com.example.bookstore.books.models;

import com.example.bookstore.auth.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    @Column(name = "likeCount", nullable = false, columnDefinition = "int default 0")
    private int likeCount;
    @Column(name = "hateCount", nullable = false, columnDefinition = "int default 0")
    private int hateCount;

    public void addLike(){
        this.likeCount+=1;
    }

    public void addHate(){
        this.hateCount-=1;
    }
}
