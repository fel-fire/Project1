package com.felfire.project.dto;
import lombok.Data;

/**
 * DTO для передачи данных о банковском счете
 */
@Data
public class BankAccountDTO {
    private Integer accountNumber;
    private Double accountScore;
}
