package com.jpa3;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

//OneToMany Book
@Data
@Entity
public class BookMToM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookMToMId;

    private String name;

    @ManyToMany(mappedBy = "book_m_to_m_set")
    private Set<Author> authorSet;
}
