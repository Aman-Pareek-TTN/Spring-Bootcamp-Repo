package com.employee.jpademo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called EmployeeRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    List<Employee> findByAgeBetween(int i, int i1);

    List<Employee> findByNameLike(String pattern);

    List<Employee> findByName(String aman);
}