package com.jpa3;

import lombok.Data;

import javax.persistence.Embeddable;

//jpa3 q1
@Embeddable
@Data
public class Address {

    private int streetNumber;
    private String location;
    private String state;
}
