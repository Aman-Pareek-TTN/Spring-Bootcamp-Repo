package spring.springboot.restful.services.example.recources;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot.restful.services.example.employee.services.Employee;
import spring.springboot.restful.services.example.employee.services.EmployeeService;

import java.util.List;
import java.util.Locale;


@RestController
public class GetApiController {

    @Autowired
    MessageSource messageSource;
    @Autowired
    EmployeeService employeeService;

    public MappingJacksonValue getMappingJacksonValue(String[] properties, Object o)
    {
        Employee employee=(Employee)o;

        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.
                filterOutAllExcept(properties);

        FilterProvider filters=new SimpleFilterProvider()
                .addFilter("EmployeeNameAndDepartment",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(employee);

        mapping.setFilters(filters);

        return mapping;

    }

    @GetMapping("/welcome") //pt1 Ques1
    public String welcomeMethod() {

        return "Welcome to Spring boot";
    }

    @GetMapping("/employees") //pt1 Ques3
    public List<Employee> getList() {

        return employeeService.getEmployeeList();
    }

    @GetMapping("/employees/{id}") //pt1 Ques 4
    public Employee getTopList(@PathVariable String id) {
        if (id.equalsIgnoreCase("top"))
            return employeeService.getTopEmployee();
        else {
            //pt1 Ques 6 Exception Thrown from here
            if (employeeService.getEmployee(id) == null)
                throw new ResourceNotFoundException("ResourceNotFoundException : Employee with id-" +
                        id + " not found");

            else {
                return employeeService.getEmployee(id);
            }
        }
    }

    @GetMapping("/hello-user-internationalized/{username}") //pt2 Ques1
    public String internationalizedHelloMethod(@RequestHeader(name = "Accept-Language", required = false) Locale locale,
                                               @PathVariable String username) {

        String message = messageSource.getMessage("my.hello.message", null, locale)
                + " " + username;

        return message;
    }

    @GetMapping("/filtered-employees/{id}") //pt2 Ques 8
    public MappingJacksonValue getFilteredEmployee(@PathVariable String id) {
        if (employeeService.getEmployee(id) == null)
            throw new ResourceNotFoundException("ResourceNotFoundException : Employee with id-" +
                    id + " not found");

        else {
            Employee employee=employeeService.getEmployee(id);

            String property1="name",
                    property2="department";

            MappingJacksonValue mapping = getMappingJacksonValue(
                    new String[]{property1,property2},employee);

            return mapping;
        }
    }




//pt1
//url to get Welcome message (Ques 1) = http://localhost:8080/welcome

//url to get all employees (Ques 3) = http://localhost:8080/employees

//url to get top employee  (Ques 4) = http://localhost:8080/employees/top

// url to post create new employee  (Ques 5) = http://localhost:8080/employees

//url to delete employee  (Ques 7) = http://localhost:8080/employees/{id}

//url to update employee  (Ques 8) = http://localhost:8080/employees/{id}

// url to get actuator (Ques 10) =    http://localhost:8080/actuator

// url to get hal browser (Ques 10) =    http://localhost:8080/browser/index.html#/


//pt2

//internationalization
// url for internationalized (Ques 2) = http://localhost:8080/hello-user-internationalized/{username}

//content negotiation:- remove comment from pom.xml for xml conversion
// url to post create new employee in xml (use accept application xml) (Ques 3) = http://localhost:8080/employees
// url to get list of employees in xml (use xml format) (Ques 4) = http://localhost:8080/employees


//swagger documentation
//url to get documentation in json  (Ques 5)= http://localhost:8080/v2/api-docs
//url to get documentation in interactive ui with rest method implementations  (Ques 5)
// = http://localhost:8080/swagger-ui/index.html#/



}
