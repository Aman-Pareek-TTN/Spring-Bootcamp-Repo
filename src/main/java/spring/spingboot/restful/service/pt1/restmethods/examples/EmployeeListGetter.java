package spring.spingboot.restful.service.pt1.restmethods.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeListGetter {

    public List<Employee> getList()
    {
        return Arrays.asList(
                new Employee("1","aman","jvm",23),
                new Employee("2","jai","spring",25),
                new Employee("3","joss","linux",28),
                new Employee("4","ray","it",21),
                new Employee("5","ram","jvm",50),
                new Employee("6","mark","python",38),
                new Employee("7","ashish","linux",42)
        );

    }

}
