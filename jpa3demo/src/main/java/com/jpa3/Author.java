package com.jpa3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int authId;

    String name;

    //jpa3 q2
    @Embedded
    Address address;

    @ElementCollection
    @CollectionTable(name="auth_subject",joinColumns=@JoinColumn(name="sub_idr"))
    List<AuthSubject> subjects;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    Set<Book> bookSet;

}
