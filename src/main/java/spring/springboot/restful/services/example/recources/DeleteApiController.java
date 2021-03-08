package spring.springboot.restful.services.example.recources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.springboot.restful.services.example.employee.services.EmployeeService;

import java.net.URI;

@RestController
public class DeleteApiController {

    @Autowired
    EmployeeService employeeService;

    @DeleteMapping("/employees/{id}") //pt1 Ques 7
    public ResponseEntity deleteEmployee(@PathVariable String id) {
        if (employeeService.getEmployee(id) == null) {
            throw new ResourceNotFoundException("ResourceNotFoundException : Employee with id-" +
                    id + " not found");
        } else {
            employeeService.deleteEmployee(id);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }
    }
}
