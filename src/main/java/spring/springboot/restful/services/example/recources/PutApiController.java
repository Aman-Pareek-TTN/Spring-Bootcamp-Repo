package spring.springboot.restful.services.example.recources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.springboot.restful.services.example.employee.services.Employee;
import spring.springboot.restful.services.example.employee.services.EmployeeService;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class PutApiController {

    @Autowired
    EmployeeService employeeService;

    @PutMapping("/employees/{id}") //pt1 Ques 8
    public ResponseEntity replaceEmployee(@Valid @RequestBody Employee newEmployee, @PathVariable String id) {

        if (newEmployee == null)
            throw new ResourceNotFoundException("ResourceNotFoundException : Employee with id-" +
                    id + " not found");

        if (employeeService.getEmployee(id) != null) {

            Employee employee = employeeService.getEmployee(id);
            employee.setAge(newEmployee.getAge());
            employee.setName(newEmployee.getName());
            employee.setDepartment(newEmployee.getDepartment());

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newEmployee.getId()).toUri();
            return ResponseEntity.created(location).build();
        } else {
            throw new ResourceNotFoundException("ResourceNotFoundException : Employee with id-" +
                    id + " not found");
        }
    }

}
