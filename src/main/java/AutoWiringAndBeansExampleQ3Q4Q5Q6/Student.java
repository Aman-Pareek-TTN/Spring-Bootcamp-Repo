package AutoWiringAndBeansExampleQ3Q4Q5Q6;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // Ambiguity Resolved (Question 5)
public class Student implements Person{

    public String getIdentification() {
        return "Student";
    }
}