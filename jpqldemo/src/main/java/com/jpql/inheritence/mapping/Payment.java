package com.jpql.inheritence.mapping;

import javax.persistence.*;

@Entity
//jpql q6
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pmode" ,discriminatorType = DiscriminatorType.STRING)*/

//jpql q7
/*@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)*/

//jpql q8
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;

    public Payment() {
    }

    public Payment(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
