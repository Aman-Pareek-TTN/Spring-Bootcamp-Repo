package spring.springboot.restful.services.example.recources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class GetApiMessageController {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/welcome") //pt1 Ques1
    public String welcomeMethod() {

        return "Welcome to Spring boot";
    }

    @GetMapping("/hello-user-internationalized/{username}") //pt2 Ques1
    public String internationalizedHelloMethod(@RequestHeader(name = "Accept-Language", required = false) Locale locale,
                                               @PathVariable String username) {

        String message = messageSource.getMessage("my.hello.message", null, locale)
                + " " + username;

        return message;
    }

}
