package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(name = "name",nullable = false,unique = true)
    private String name;
    @Column(name = "description",nullable = false,unique = true)
    private String description;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books=new HashSet<Book>();

}
