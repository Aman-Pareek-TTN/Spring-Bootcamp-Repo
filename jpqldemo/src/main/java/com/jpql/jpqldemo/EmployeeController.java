package com.jpql.jpqldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/addemployee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Employee user = employeeService.saveEmployeeDetails(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/getemployee")
    public Iterable<Employee> retriveAllEmployeeUser() {

        return employeeService.retriveEmployeeDetails();
    }


    // JPQL

    @GetMapping(path = "/getallemployee")
    public List<Object[]> retriveAllEmployee() {

        return employeeService.getAllEmployee();
    }

    @Transactional
    @PatchMapping(path = "/updateemployee")
    public void updateSalary(@RequestParam int salary) {

        int avgSal=employeeService.getAvgEmployeeSalary();

        employeeService.updateEmployeeSalary(avgSal,(int)salary);
    }

    @Transactional
    @Rollback(false)
    @DeleteMapping(path = "/deleteemployee")
    public void deleteEmployeeDetails() {

        int minSal=employeeService.getMinEmployeeSalary();

        employeeService.deleteEmployee(minSal);
    }

    //Native SQL Query
    @GetMapping(path = "/getemployeenq")
    public List<Object[]> retrieveEmployeeNQ(@RequestParam String lastName) {

        return employeeService.getEmployeeNQ(lastName);
    }

    @Transactional
    @DeleteMapping(path = "/deleteemployeenq")
    public void deleteEmployeeNQ(@RequestParam int age) {

        employeeService.deleteEmployeeDetailNQ(age);
    }

}
