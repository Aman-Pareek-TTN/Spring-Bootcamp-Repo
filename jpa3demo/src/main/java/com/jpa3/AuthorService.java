package com.jpa3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
