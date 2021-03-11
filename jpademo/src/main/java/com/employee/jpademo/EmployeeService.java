package com.employee.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //jpa q3
    public Employee saveEmployeeDetails(Employee employee){

        return employeeRepository.save(employee);
    }

    //jpa q4
    public Employee readEmployeeDetails(int id){

        return employeeRepository.findById(id).get();
    }

    //jpa Q5
    public Employee updateEmployeeDetails(Employee employee){

        Optional<Employee> tempEmployee = employeeRepository.findById(employee.getId());

        Employee employee1=tempEmployee.get();

        employee1.setName(employee.getName());
        employee1.setAge(employee.getAge());
        employee1.setLocation(employee.getLocation());

        employeeRepository.save(employee1);
        return employee1;
    }

    //jpa Q6
    public Employee deleteEmployee(int id){

        if(employeeRepository.existsById(id)) {
            Employee employee = employeeRepository.findById(id).get();
            employeeRepository.deleteById(id);
            return employee;
        }
        else
            return null;

    }

    //jpa Q7
    public int countEmployees() {

        return (int) employeeRepository.count();
    }

    //jpa Q9
    public List<Employee> employeeFindByEmployeeName(String name) {

        List<Employee> employees =  employeeRepository.findByName(name);
        return employees;

    }

    //jpa Q10
//    public List<Employee> employeeFindByNameStartingWithSeq(String seq) {
//
//        List<Employee> employees = employeeRepository.findByNameStartingWith(seq);
//
//        return employees;
//
//    }

    //jpa Q11
    public List<Employee> employeeFindByEmployeeAgeBetween() {

        List<Employee> employees = employeeRepository.findByAgeBetween(28,32);

        return employees;

    }



}
