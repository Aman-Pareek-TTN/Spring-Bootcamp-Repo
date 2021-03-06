package spring.spingboot.restful.service.pt1.restmethods.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class GetListServiceQ3 {

    @RequestMapping(method = RequestMethod.GET,path = "/GetList")
    public List<Employee> getList()
    {
       return new EmployeeService().getEmployeeList();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(GetListServiceQ3.class,args);

    }

//url = http://localhost:8080/GetList

}
