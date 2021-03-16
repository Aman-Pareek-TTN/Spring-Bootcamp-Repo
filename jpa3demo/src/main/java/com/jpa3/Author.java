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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authId;

    private String name;

    //jpa3 q2
    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name="auth_subject",joinColumns=@JoinColumn(name="auth_id"))
    private List<AuthSubject> subjects;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> bookSet;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_book_m_to_m",
            joinColumns = @JoinColumn(name = "authId", referencedColumnName = "auth_id"),
            inverseJoinColumns = @JoinColumn(name = "bookMtoMId", referencedColumnName = "book_m_to_m_id"))
    private Set<BookMToM> bookMToMSet;

    public void addBook(Book book){

        if(bookSet==null)
        {
            bookSet=new HashSet<>();
        }
        book.setAuthor(this);
        bookSet.add(book);
    }

    public void addAddress(int street, String location, String state){

        Address address=new Address();
        address.setStreetNumber(street);
        address.setLocation(location);
        address.setState(state);

        this.address=address;

    }


}
