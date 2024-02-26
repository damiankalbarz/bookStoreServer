package com.example.bookstore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BOOK_TBL")
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String author;
    private String category;
    private String description;
    private int price;
    @Column(name = "likeCount", nullable = false, columnDefinition = "int default 0")
    private int likeCount=0;
    @Column(name = "hateCount", nullable = false, columnDefinition = "int default 0")
    private int hateCount=0;

    @OneToMany
    private List<Comment> comments;

}
