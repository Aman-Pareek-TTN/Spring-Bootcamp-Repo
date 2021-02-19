package com.company;


import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        FP1 fp1= (int a, int b)-> a>b;
        System.out.println("FP1 res :" + fp1.compareNums(1,2));

        System.out.println();

        FP2 fp2= a -> a++;
        System.out.println("FP2 res :" + fp2.increaseNum(1));

        System.out.println();

        FP3 fp3= (String a,String b)-> a+b;
        System.out.println("FP3 res :" + fp3.concatStrings("Aman","Pareek"));

        System.out.println();

        FP4 fp4= a->a.toUpperCase();
        System.out.println("FP4 res :" + fp4.stringBig("aman"));

    }
}
