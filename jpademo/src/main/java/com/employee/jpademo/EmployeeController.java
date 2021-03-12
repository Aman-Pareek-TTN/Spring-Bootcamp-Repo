package com.employee.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save-employee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Employee user = employeeService.saveEmployeeDetails(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/read-employee/{id}")
    public Employee getEmployee(@PathVariable int id) {

        return employeeService.readEmployeeDetails(id);

    }

    @PutMapping("/update-employee/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee)
    {
        Employee user = employeeService.updateEmployeeDetails(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping("/count-employee")
    public String countEmployee() {

        return "Employee count = " + employeeService.countEmployees();
    }

    @GetMapping("/read-employee-by-name/{name}")
    public List<Employee> getEmployeesWithName(@PathVariable String name) {

        return employeeService.employeeFindByEmployeeName(name);

    }

    @GetMapping("/read-employee-that-has-a-as-starting-letter")
    public List<Employee> getEmployeeStartingWith() {

        return employeeService.employeeFindByNameStartingWithLettera();

    }

    @GetMapping("/read-employee-between-age")
    public List<Employee> getEmployeeWithAgeBetween() {

        return employeeService.employeeFindByEmployeeAgeBetween28And32();
    }


}
