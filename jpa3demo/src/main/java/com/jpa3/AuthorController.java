package com.jpa3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService service;

    @PostMapping("/addAuthor")
    public void addAuthor(@RequestBody Author author)
    {
        service.addAuthor(author);
    }

    @GetMapping("/getAllAuthors")
    public List<Author> getAllAuthors(){

        return service.getAuthors();
    }
}
