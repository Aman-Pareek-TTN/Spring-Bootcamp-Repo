package spring.spingboot.restful.service.pt1.restmethods.examples.employee.services;


import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Component //Ques 2
public class Employee{

    private String id;

    @Size(min=2)
    private String name;
    private String department;

    @Min(18)
    @Max(60)
    private int age;

    public Employee(){
    }


    public Employee(String id, String name, String department, int age){
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){

        return "[ id: " +
                this.getId() +
                ", name : " +
                this.getName() +
                ", department: " +
                this.getDepartment() +
                ", age: " +
                this.getAge() +
                " ]";
    }

}
