package spring.springboot.restful.services.example.recources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot.restful.services.example.employee.services.Employee;
import spring.springboot.restful.services.example.employee.services.EmployeeFilterConfig;
import spring.springboot.restful.services.example.employee.services.EmployeeService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class GetApiEmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeFilterConfig employeeFilterConfig;

    @Autowired
    MappingJacksonValue mapping;


    @GetMapping("/employees") //pt1 Ques3
    public MappingJacksonValue getList() {

        return mapping;
    }

    @GetMapping("/employees/{id}") //pt1 Ques 4, pt2 Ques 8(Filtered Employees)
    public EntityModel<Employee> getTopList(@PathVariable String id) {

        Employee tempEmployee;

        if(id.equalsIgnoreCase("top"))
            tempEmployee=employeeService.getTopEmployee();
        else
            tempEmployee= employeeService.getEmployee(id);

        if (tempEmployee == null)
            throw new ResourceNotFoundException("ResourceNotFoundException : Employee with id-" +
                    id + " not found");

        //Hateoas Question
        EntityModel<Employee> entityModel = EntityModel.of(tempEmployee);
        Link link = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getList())
                .withRel("employees");
        entityModel.add(link);

        return entityModel;
    }

}
