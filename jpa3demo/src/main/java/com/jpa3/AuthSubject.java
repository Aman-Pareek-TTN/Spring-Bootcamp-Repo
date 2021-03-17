package com.jpa3;

import lombok.Data;

import javax.persistence.*;

@Entity
public class AuthSubject {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int authSubId;

   private String name;

   @ManyToOne
   @JoinColumn(name = "authorsubjectid",referencedColumnName = "id")
   private Author author;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}