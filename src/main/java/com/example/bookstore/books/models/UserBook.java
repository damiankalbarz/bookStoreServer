package com.example.bookstore.books.models;

import com.example.bookstore.auth.models.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user_book")
public class UserBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
