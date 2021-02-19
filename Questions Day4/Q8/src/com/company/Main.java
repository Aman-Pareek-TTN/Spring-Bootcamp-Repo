package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("Printed using Interface1 reference variable");
        Interface1 interface1Obj=new MultipleInheritenceClass();
        System.out.println(interface1Obj.defaultPrint1());
        System.out.println();

        System.out.println("Printed using Interface2 reference variable");
        Interface2 interface2Obj=new MultipleInheritenceClass();
        System.out.println(interface2Obj.defaultPrint2());
        System.out.println();


        System.out.println("Printed using multipleInheritenceClass reference variable");
        MultipleInheritenceClass multipleInheritenceClassObj=new MultipleInheritenceClass();
        System.out.println(multipleInheritenceClassObj.defaultPrint1());
        System.out.println(multipleInheritenceClassObj.defaultPrint2());
    }
}
