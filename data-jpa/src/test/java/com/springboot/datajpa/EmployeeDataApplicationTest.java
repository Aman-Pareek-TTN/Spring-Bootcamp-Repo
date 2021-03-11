package com.springboot.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeDataApplicationTest {

    @Autowired
    EmployeeRepository repository;


    //jpa Q3
    @Test
    public void testCreate(){

        Employee employee= new Employee();
        employee.setName("aman");
        employee.setLocation("jaipur");
        employee.setAge(23);
        repository.save(employee);
    }

    //jpa Q4
    @Test
    public void testRead(){

        Employee employee= repository.findById(1).get();
        System.out.println("Read emplyee from DB is:\n " + employee );
    }

    //jpa Q5
    @Test
    public void testUpdate(){
        Employee employee= repository.findById(3).get();
        System.out.println("Employee before change is:\n " + employee );
        employee.setAge(30);

        repository.save(employee);
        System.out.println("Employee after change is:\n " + employee );


    }

    //jpa Q6
    @Test
    public void testDelete(){

        if(repository.existsById(3)) {
            Employee employee = repository.findById(3).get();
            System.out.println("Deleted Employee is:\n " + employee);
            repository.deleteById(3);
        }

    }

    //jpa Q7
    @Test
    public void testCount() {

        System.out.println("Total number of employees is: "+ repository.count());
    }

    //jpa Q9
    @Test
    public void testFindByName() {

        List<Employee> employees = repository.findByName("aman");

        employees.forEach(System.out::println);

    }

    //jpa Q11
    @Test
    public void testFindByNameStartingWitha() {

        List<Employee> employees = repository.findByNameStartingWitha();

        employees.forEach(System.out::println);

    }

    //jpa Q11
    @Test
    public void testFindByAgeBetween() {

        List<Employee> employees = repository.findByAgeBetween(28,32);

        employees.forEach(System.out::println);

    }
}