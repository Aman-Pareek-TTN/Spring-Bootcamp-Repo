package com.jpa3;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class AuthSubject {

   private String name;
}