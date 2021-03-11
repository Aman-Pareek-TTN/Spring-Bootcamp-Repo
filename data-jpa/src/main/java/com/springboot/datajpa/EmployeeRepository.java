package com.springboot.datajpa;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

//jpa Q2
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    //jpa Q9
    List<Employee> findByName(String name);

    //jpa Q10
    List<Employee> findByNameStartingWitha();

    //jpa Q11
    List<Employee> findByAgeBetween(int age1, int age2);

}
