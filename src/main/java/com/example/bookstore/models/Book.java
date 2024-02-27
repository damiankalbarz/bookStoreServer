package com.example.bookstore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BOOK_TBL")
public class Book {
    @Column(name = "book_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private String category;
    private String description;
    private int price;
    @Column(name = "likeCount", nullable = false, columnDefinition = "int default 0")
    private int likeCount=0;
    @Column(name = "hateCount", nullable = false, columnDefinition = "int default 0")
    private int hateCount=0;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    //@JoinColumn(name = "book_id")
    private List<Comment> comments = new ArrayList<>();


    public void addComments(Comment comment){
        comment.setBook(this);
        comments.add(comment);
        //System.out.println("Added comment to book: " + comment);
    }

}
