package spring.spingboot.restful.service.pt1.restmethods.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GetTopEmployeeServiceQ4 {

    @RequestMapping(method = RequestMethod.GET,path = "/GetTopEmployee")
    public Employee getTopList()
    {
        return new EmployeeService().getTopEmployee();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(GetTopEmployeeServiceQ4.class,args);

    }

//url = http://localhost:8080/GetTopEmployee
}
