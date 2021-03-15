package com.jpql.component.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/addpersondetails")
    public void addPerson(@RequestBody Person person){

        personService.savePersonDetails(person);

    }

    @GetMapping("/getPersons")
    public List<Person> getPersons(){

        return personService.getPersonsDetails();

    }
}
