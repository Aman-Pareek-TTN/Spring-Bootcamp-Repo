package spring.spingboot.restful.service.pt1.restmethods.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.spingboot.restful.service.pt1.restmethods.examples.employee.services.Employee;
import spring.spingboot.restful.service.pt1.restmethods.examples.employee.services.EmployeeService;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@SpringBootApplication
@RestController
public class EmployeeRestServices {

    EmployeeService employeeService;

    public EmployeeRestServices() {
        this.employeeService = new EmployeeService();
    }

    @GetMapping("/Employees") //Ques 3
    public List<Employee> getList()
    {
       return employeeService.getEmployeeList();
    }

    @GetMapping("/Employees/{id}") //Ques 4
    public Employee getTopList(@PathVariable String id)
    {
        if(id.equalsIgnoreCase("top"))
            return employeeService.getTopEmployee();
        else {
            //Ques 6 Exception Thrown from here
            if (employeeService.getEmployee(id) == null)
                throw new ResourceNotFoundException("ResourceNotFoundException : Employee with id-" +
                        id + " not found");

            else
                return employeeService.getEmployee(id);
        }
    }

    @PostMapping("/Employees") // Ques 5 and Ques 9 for validation
    public ResponseEntity createEmployee(@Valid @RequestBody Employee employee)
    {
        //System.out.println(employee);
        employeeService.insertEmployee(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping ("/Employees/{id}") //Ques 7
    public ResponseEntity deleteEmployee(@PathVariable String id)
    {
        if (employeeService.getEmployee(id) == null) {
            throw new ResourceNotFoundException("ResourceNotFoundException : Employee with id-" +
                    id + " not found");
        }
        else {
            employeeService.deleteEmployee(id);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @PutMapping("/Employees/{id}")
    public ResponseEntity replaceEmployee(@Valid @RequestBody Employee newEmployee, @PathVariable String id) {

        if(employeeService.getEmployee(id)!=null) {

            Employee employee = employeeService.getEmployee(id);
            employee.setAge(newEmployee.getAge());
            employee.setName(newEmployee.getName());
            employee.setDepartment(newEmployee.getDepartment());

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newEmployee.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
        else
        {
            throw new ResourceNotFoundException("ResourceNotFoundException : Employee with id-" +
                    id + " not found");
        }
    }


        public static void main(String[] args)
    {
        SpringApplication.run(EmployeeRestServices.class,args);

    }





//url to get all employees (Ques 3) = http://localhost:8080/Employees

//url to get top employee  (Ques 4) = http://localhost:8080/Employees/top

// url to get create new employee  (Ques 5) = http://localhost:8080/Employees

//url to delete employee  (Ques 7) = http://localhost:8080/Employees/{id}

//url to update employee  (Ques 8) = http://localhost:8080/Employees/{id}

// url to get actuator (Ques 10) =    http://localhost:8080/actuator

// url to get hal browser (Ques 10) =    http://localhost:8080/browser/index.html#/
}
