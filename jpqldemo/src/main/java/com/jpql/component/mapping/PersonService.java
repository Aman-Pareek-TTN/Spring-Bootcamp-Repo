package com.jpql.component.mapping;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void savePersonDetails(Person person){

        personRepository.save(person);
    }

    public List<Person> getPersonsDetails(){

        return (List<Person>) personRepository.findAll();
    }
}

