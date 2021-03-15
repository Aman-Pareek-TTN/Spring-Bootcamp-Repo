package jpa.jpa2;

import javax.persistence.*;

@Entity
@Table(name = "employeetable")
public class EmployeeJPQL {

    @Id                    // Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empid")
    private int id;

    @Column(name = "empfirstname")
    private String firstName;

    @Column(name = "emplastname")
    private String lastName;

    @Column(name = "empsalary")
    private double salary;

    @Column(name = "empage")
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

