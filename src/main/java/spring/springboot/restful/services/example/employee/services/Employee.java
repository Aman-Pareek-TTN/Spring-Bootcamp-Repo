package spring.springboot.restful.services.example.employee.services;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity//jpa exercise Ques 1m
@Table
@Component //pt1 Ques 2
@ApiModel(description = "All details about the Employee") //pt2 Ques 6
//@JsonFilter("EmployeeNameAndDepartment")
public class Employee{

    @Id
    //@JsonIgnore //static way
    @ApiModelProperty(notes="remove comments for applying static filtering")
    private String id;

    //pt2 Ques 6 attribute description
    @ApiModelProperty(notes="name should have more than 2 letters")
    //pt1 Q9 validation
    @Size(min=2)
    private String name;
    private String department;

    //pt2 Ques 6 attribute description
    @ApiModelProperty(notes="age must be GT 18 and LT 60")
    //pt1 Q9 validation
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
