package spring.springboot.restful.services.example.recources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.springboot.restful.services.example.employee.services.Employee;
import spring.springboot.restful.services.example.employee.services.EmployeeService;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class PostApiController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees") // pt1 Ques 5 and Ques 9 for validation
    public ResponseEntity createEmployee(@Valid @RequestBody Employee employee) {
        //System.out.println(employee);
        employeeService.insertEmployee(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

}
