package com.jpa3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository repository;

    public void addAuthor(Author author){

        repository.save(author);
    }

    public List<Author> getAuthors(){

        return (List<Author>) repository.findAll();
    }

    public void addSubjects(Author author,String... subNames){

        List<AuthSubject> subjects=new ArrayList<>();
        AuthSubject subject= new AuthSubject();

        for(String name : subNames)
        {
            subject = new AuthSubject();
            subject.setName(name);
            subjects.add(subject);
        }

        author.setSubjects(subjects);


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

    public void addMToMBooks(Author author,String... bookNames){

        BookMToM book=new BookMToM();
        Set<BookMToM> bookMToMSet =  new HashSet<>();

        for(String name : bookNames)
        {
            book = new BookMToM();
            book.setName(name);
            bookMToMSet.add(book);

        }

        author.setBookMToMSet(bookMToMSet);

    }
}
