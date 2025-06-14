package com.felfire.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Сущность - банковская транзакция
 */
@Entity
@Table(name = "transfer")
@Getter @Setter
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    LocalDateTime transferTime;
    Integer transferFrom;
    Integer transferTo;
    Double transferAmount;
    Integer transferOwner;
}
