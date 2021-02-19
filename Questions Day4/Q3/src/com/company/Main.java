package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static <T> List<T> getIntList(T arr[]){

        return  Arrays.asList(arr);

    }


    public static void main(String[] args) {

        int num1=9,num2=8;

        List<Integer> list=getIntList(new Integer[]{6,1,8,9,13,43,3,7,14});

        MyFunctions myFunctions=new MyFunctions();

       System.out.println("Implemented Sum function result:");
       int sum= list.stream().reduce(0,myFunctions::plus);
        System.out.println(sum);

        System.out.println("Implemented minus function result:");
       int minus= list.stream().reduce(200,myFunctions::minus);
        System.out.println(minus);

        System.out.println("Implemented static multiply function result:");
        int multiply= list.stream().reduce(200,MyFunctions::multiply);
        System.out.println(multiply);




    }
}
