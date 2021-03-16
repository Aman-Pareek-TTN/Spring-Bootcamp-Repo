package com.jpa3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

/*
    @PostMapping("/addSampleAuthor")
    public void addSampleAuthor()
    {
        Author author = new Author();
        author.setName("manu");

        author.addAddress(7,"mumbai","maharashtra");

        service.addSubjects(author,"cars","bikes","mechanics");

        service.addBooks(author,"carsAndItsFunctions",
                "bikesAndItsFunctions","mechanicsAndItsFunctions");

        service.addAuthor(author);
    }
*/

}
