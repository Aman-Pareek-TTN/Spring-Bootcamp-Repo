package AutoWiringAndBeansExampleQ3Q4Q5Q6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(MainApplication.class,args);

        PrintClass printClass=applicationContext.getBean(PrintClass.class);

        //Accessing Bean's Property (Question 4)
        printClass.printPerson();
    }
}
