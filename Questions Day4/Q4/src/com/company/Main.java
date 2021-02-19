package com.company;

import java.util.List;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        //Getting employee with params
        Supplier<Employee> employeeSupplier = Employee::new;
        Employee newEmployee1=employeeSupplier.get();
        System.out.println("Without Params Employee is:" + newEmployee1);

        EmployeeGetWithParams employeeGetWithParams=Employee::new;
        Employee newEmployee2=employeeGetWithParams.get("101","uno","JVM",23);
        System.out.println("With Params Employee is:" + newEmployee2);
    }
}
