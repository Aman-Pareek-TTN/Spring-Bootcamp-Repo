package jpa.jpa2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeControllerJPQL {

    @Autowired
    EmployeeJPQLRepository repository;

    @GetMapping("/jpql-create-employee")
    public EmployeeJPQL createJPQLEmployee(){

        EmployeeJPQL employeeJPQL = new EmployeeJPQL();
        employeeJPQL.setId(2);
        employeeJPQL.setFirstName("manoj");
        employeeJPQL.setLastName("singh");
        employeeJPQL.setSalary(40000);
        employeeJPQL.setAge(24);

        repository.save(employeeJPQL);

        return employeeJPQL;
    }

    @GetMapping("/jpql-find-fname-lname")
    public List<Object[]> findFnameLname(){

        return repository.findAllEmployeeFNameAndLName();
    }


}
