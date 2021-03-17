package com.jpa3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //jpa3 q2
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<AuthSubject> subjectSet = new ArrayList<AuthSubject>();

/*
    @OneToOne(mappedBy = "author",cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
*/


/*
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books=new ArrayList<>();
*/


       @ManyToMany(cascade = CascadeType.ALL)
       @JoinTable(name = "authors_books",
               joinColumns = @JoinColumn(name = "author_id",referencedColumnName = "id"),
               inverseJoinColumns =@JoinColumn(name = "book_id",referencedColumnName = "id") )
       private List<Book> books = new ArrayList<Book>();

/*
    public void addBook(Book book){
        if(bookSet==null)
        {
            bookSet=new ArrayList<>();
        }
        book.setAuthor(this);
        bookSet.add(book);
    }
*/


    public void addAddress(int street, String location, String state){

        Address address=new Address();
        address.setStreetNumber(street);
        address.setLocation(location);
        address.setState(state);

        this.address=address;

    }


}
