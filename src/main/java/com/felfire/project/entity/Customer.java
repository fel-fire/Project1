package com.felfire.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Сущность - пользователь
 */
@Entity
@Getter @Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String lastname;
    String firstname;
    String patronimyc;
    @Column(name = "town")
    String town;
    String passport;
    @Column(name = "phonenumber")
    String phoneNumber;
    String username;
    @Column(name = "passwrd")
    String password;

}
