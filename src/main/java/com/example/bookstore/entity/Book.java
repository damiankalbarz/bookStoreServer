package com.example.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
