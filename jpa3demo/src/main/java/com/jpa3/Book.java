package com.jpa3;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

//jpa3 q5
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int bookId;

    String name;

    @ManyToOne
    @JoinColumn(name = "auth_id")
    Author author;
}
