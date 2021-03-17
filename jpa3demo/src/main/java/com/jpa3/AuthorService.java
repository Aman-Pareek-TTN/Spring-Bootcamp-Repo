package com.jpa3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository repository;

    public void addAuthor(Author author){

// many to many

        List<Book> bookSet = author.getBooks();
        for(Book book : bookSet)
        {
            book.setAuthor(Arrays.asList(author));
        }

// one to many mapping

//        List<Book> bookSet = author.getBooks();
//        for(Book book : bookSet)
//        {
//            book.setAuthor(author);
//        }


/*
        // one to one mapping
        Book book = author.getBook();
        book.setAuthor(author);
*/

        repository.save(author);

    }

//    public List<Author> getAuthors(){
//
//        return (List<Author>) repository.findAll();
//    }

    /*
    public void addSubjects(Author author,String... subNames){

        List<AuthSubject> subjects=new ArrayList<>();
        AuthSubject subject= new AuthSubject();

        for(String name : subNames)
        {
            subject = new AuthSubject();
            subject.setName(name);
            subjects.add(subject);
        }

        author.setSubjectSet(subjects);


    }

    public void addBooks(Author author,String... bookNames){

        Book book =new Book();

        for(String name : bookNames)
        {
            book = new Book();
            book.setName(name);
            author.addBook(book);

        }

    }

     */
}
