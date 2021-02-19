package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        //int[] arr={9,43,8,3,7,33,5,1,16,99};
        List<Integer> myNumbers;
        myNumbers = new ArrayList<Integer>();

        myNumbers.add(10);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(25);
        myNumbers.add(1);
        myNumbers.add(5);
        myNumbers.add(64);
        myNumbers.add(2);

        System.out.println("Numbers From List:");
        myNumbers.stream().forEach(System.out::println);

        System.out.println("Avg of Numbers :");
        int avgOfList=myNumbers.stream().map(x->x+x).reduce(0,(num1,num2)->(num1+num2)/2);
        System.out.println(avgOfList);




    }
}
