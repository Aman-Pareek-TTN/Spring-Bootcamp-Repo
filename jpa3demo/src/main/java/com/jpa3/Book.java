package com.jpa3;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

//OneToMany Book
@Data
//jpa3 q5
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "auth_id")
    private Author author;
}
