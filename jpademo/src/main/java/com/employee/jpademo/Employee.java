package com.employee.jpademo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity     // This tells Hibernate to make a table out of this class
public class Employee {

    @Id                    // Primary Key
    private int id;
    private String name;
    private int age;
    private String location;

    public Employee() {
    }

    public Employee(int id, String name, int age, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

