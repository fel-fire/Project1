package com.felfire.project.dto;

import lombok.Data;

import java.util.List;

/**
 * DTO для передачи данных о всех банковски счетах и общей сумме денежных средств на них
 */
@Data
public class BankAccountListDTO {
    private List<BankAccountDTO> accounts;
    private Double amount;
}
