package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(name = "isbn",nullable = false,unique = true)
    private String isbn;
    @Column(name = "name",nullable = false)
    private String name;


    @Column(name = "description",nullable = false,unique = true)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="books_author",
    joinColumns={@JoinColumn(name="book_authors")},
    inverseJoinColumns={@JoinColumn(name="author_id")})
    private Set<Author> authors = new HashSet<>();

}