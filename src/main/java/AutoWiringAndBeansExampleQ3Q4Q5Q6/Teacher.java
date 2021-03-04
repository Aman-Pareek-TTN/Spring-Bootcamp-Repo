package AutoWiringAndBeansExampleQ3Q4Q5Q6;

import org.springframework.stereotype.Component;

@Component
public class Teacher implements Person{


    public String getIdentification() {
        return "Teacher";
    }
}
