package com.company;

public class Main {

    public static void main(String[] args) {

        MyInterface myInterfaceObj= new MyInterface() {

        };

        System.out.println(MyInterface.staticPrint());
        System.out.println(myInterfaceObj.defaultPrint());



    }
}
