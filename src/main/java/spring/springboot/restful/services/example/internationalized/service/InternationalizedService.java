package spring.springboot.restful.services.example.internationalized.service;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

//pt2 Question 1
public class InternationalizedService {

    @Bean
    public LocaleResolver defaultLocaleResolver(){
        SessionLocaleResolver sessionLocaleResolver= new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);

        return sessionLocaleResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
       // messageSource.setBasename("messages");

        return messageSource;

    }

    public static void main(String[] args) {

        SpringApplication.run(InternationalizedService.class,args);
    }
}
