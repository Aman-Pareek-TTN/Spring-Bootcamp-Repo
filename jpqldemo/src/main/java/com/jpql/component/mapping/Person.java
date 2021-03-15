package com.jpql.component.mapping;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Person {

    @Id
    int id;
    String name;

    @Embedded
    Address address;

}
