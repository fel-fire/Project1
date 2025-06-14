package com.felfire.project.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO для передачи данных о банковской транзакции
 */
@Data
public class TransferDTO {
    private LocalDateTime time;
    private Integer from;
    private Integer to;
    private Double amount;
}
