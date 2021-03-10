package spring.springboot.restful.services.example.employee.services;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeFilterConfig {

    @Autowired
    EmployeeService employeeService;

    @Bean
    public MappingJacksonValue getMappingJacksonValue(){


        List<Employee> empList=employeeService.getEmployeeList();

        String property1="name",
                property2="department";

        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.
                filterOutAllExcept(property1, property2);

        FilterProvider filters=new SimpleFilterProvider()
                .addFilter("EmployeeNameAndDepartment",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(empList);

        mapping.setFilters(filters);

        return mapping;

    }

    public MappingJacksonValue getMappingJacksonValue(String [] properties, List<Employee> employeeList){

        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.
                filterOutAllExcept(properties);

        FilterProvider filters=new SimpleFilterProvider()
                .addFilter("EmployeeNameAndDepartment",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(employeeList);

        mapping.setFilters(filters);

        return mapping;

    }
}