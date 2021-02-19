package com.company;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class GetFIs {

    private Predicate<Integer> predicate;
    private Consumer<Integer> consumer;
    private Supplier<Integer> supplier;
    private Function<Integer,Integer> function;
    private final int VAL=5;
    private Student student;

    public Predicate<Integer> getPredicate(){

        predicate=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {

                return integer>5;
            }
        };

        return predicate;
    }


    public Consumer<Integer> getConsumer(){

        consumer= new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("This is the Element coming from stream: " + integer);
            }
        };

        return consumer;
    }

    public Supplier<Student> getStudentSupplier(){

        Supplier supplier=new Supplier() {
            @Override
            public Object get() {
                return new Student(101,"Krish", "M",17);
            }
        };
        return supplier;
    }

    public Function<Integer,Integer> getFunction(){

        function=new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer+VAL;
            }
        };
        return function;
    }
}


