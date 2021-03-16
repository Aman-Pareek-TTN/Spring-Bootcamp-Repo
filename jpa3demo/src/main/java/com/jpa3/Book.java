package com.jpa3;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

//OneToMany Book
@Data
//jpa3 q5
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

/*
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    */

    /*
     @ManyToMany
    @JoinColumn(name = "author_id")
    private List<Author> author;
*/

}
