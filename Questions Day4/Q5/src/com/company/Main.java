package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

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

        GetFIs getFis=new GetFIs();


        System.out.println("Example of Predicate and Consumer, This example prints numbers greater than 5");
        myNumbers.stream().filter(getFis.getPredicate()).forEach(getFis.getConsumer());
        System.out.println();


        System.out.println("Example of Function and Consumer, This example prints element+5");
        myNumbers.stream().map(getFis.getFunction()).forEach(getFis.getConsumer());
        System.out.println();

        System.out.println("Example of Supplier that returns an student object");
        Supplier<Student> studentSupplier= getFis.getStudentSupplier();
        Student student= studentSupplier.get();
        System.out.println(student);

    }
}
