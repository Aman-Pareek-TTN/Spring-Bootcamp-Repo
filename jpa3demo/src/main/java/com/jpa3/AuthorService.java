package com.jpa3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository repository;

    public void addAuthor(Author author){

//        List<Book> bookSet = author.getBookSet();
//        for(Book book : bookSet)
//        {
//            book.setAuthor(author);
//        }

        repository.save(author);

    }

    public List<Author> getAuthors(){

        return (List<Author>) repository.findAll();
    }

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
