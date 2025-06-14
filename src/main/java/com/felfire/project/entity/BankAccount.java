package com.felfire.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Сущность - банковский счет
 */
@Entity
@ToString
@Getter @Setter
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer accountNumber;
    Double accountScore;
    @Column(name = "account_owner")
    Integer accountOwner;
}
