package spring.basics.sess1.AutoWiringAndBeansExampleQ3Q4Q5Q6;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Making this class object a bean(Question 3)
public class PrintClass {


    Person person;

    //After dependency declaration
    //we can either add bean to it using
    //1. setters and 2. constructor
    //so we used constructor injection here

    //Constructor Injection (Question 6)
    @Autowired
    public PrintClass(Person person) {
        this.person = person;
    }

    public void printPerson()
    {
        System.out.println("This Person is a " + person.getIdentification());
    }
}
