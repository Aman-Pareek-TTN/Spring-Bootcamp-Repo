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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

/*
    @OneToOne
    private Author author;
*/

/*
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
*/


    @ManyToMany(mappedBy = "books")
    private List<Author> author;


}
