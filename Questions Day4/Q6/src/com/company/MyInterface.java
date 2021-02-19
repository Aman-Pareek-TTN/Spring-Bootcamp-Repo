package com.company;

public interface MyInterface {

    default public String defaultPrint(){

        return "This is the DEFAULT Method of this interface";
    }

    static public String staticPrint(){

        return "This is the STATIC Method of this interface";
    }
}
