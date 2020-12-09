package com.springboottesting.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class User {

    @Id
    private int id;
    private String name;
    private int age;
    private String address;
}
