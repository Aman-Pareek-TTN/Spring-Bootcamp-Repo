package com.jpql.jpqldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //JPQL

    public Employee saveEmployeeDetails(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Iterable<Employee> retriveEmployeeDetails() {
        return employeeRepository.findAll();
    }

    public List<Object[]> getAllEmployee() {
        return employeeRepository.findAllEmployee();
    }

    public void updateEmployeeSalary(int avgSal, int salary) {
        employeeRepository.updateSalary(avgSal,salary);
    }

    public void deleteEmployee(int minSal) {

        employeeRepository.deleteEmployee(minSal);
    }

    public int getAvgEmployeeSalary(){

        return employeeRepository.findAvgEmployeeSalary();
    }

    public int getMinEmployeeSalary(){

        return employeeRepository.findMinEmployeeSalary();
    }

    //Native SQL Query

    public List<Object[]> getEmployeeNQ(String lastName) {

        return employeeRepository.findEmployeeNQ(lastName);
    }

    public void deleteEmployeeDetailNQ(int age) {
        employeeRepository.deleteEmployeeNQ(age);
    }


}
