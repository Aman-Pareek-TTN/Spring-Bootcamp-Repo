package com.springboot.datajpa.controllers;

import com.springboot.datajpa.Employee;
import com.springboot.datajpa.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaController {

    @Autowired
    EmployeeRepository repository;

    @PostMapping("/employee")
    public void createEmployee(@RequestBody Employee employee){

        repository.save(employee);
    }
}
