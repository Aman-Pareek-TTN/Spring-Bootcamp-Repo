package jpa.jpa2;

import javax.persistence.*;

@Entity
@Table(name = "employeeTable")
public class EmployeeJPQL {

    @Id                    // Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private int id;

    @Column(name = "empFirstName")
    private String firstName;

    @Column(name = "empLastName")
    private String lastName;

    @Column(name = "empSalary")
    private double salary;

    @Column(name = "empAge")
    private int age;

    public EmployeeJPQL() {
    }

    public EmployeeJPQL(int id, String firstName, String lastName, double salary, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.age = age;
    }

    public EmployeeJPQL(String firstName, String lastName, double salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

