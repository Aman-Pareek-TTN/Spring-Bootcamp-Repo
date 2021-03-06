package spring.spingboot.restful.service.pt1.q1.welcome.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WelcomeRestServiceQ1 {

    @RequestMapping(method = RequestMethod.GET,path = "/Welcome")
    public String welcomeMethod(){

        return "Welcome to my Spring boot";
    }

    public static void main(String[] args)
    {
        SpringApplication.run(WelcomeRestServiceQ1.class,args);

    }

//url = http://localhost:8080/Welcome

}
