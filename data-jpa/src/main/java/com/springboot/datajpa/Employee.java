package com.springboot.datajpa;


import javax.persistence.*;

@Entity//jpa exercise Ques 1
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String location;

    private int age;

    public Employee(){
    }


    public Employee(int id, String name, String location, int age) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.age = age;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
                ", location: " +
                this.getLocation() +
                ", age: " +
                this.getAge() +
                " ]";
    }

}
