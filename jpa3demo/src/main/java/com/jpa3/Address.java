package com.jpa3;

import lombok.Data;

import javax.persistence.Embeddable;

//jpa3 q1
@Embeddable
@Data
public class Address {

    int streetNumber;
    String location;
    String State;
}
