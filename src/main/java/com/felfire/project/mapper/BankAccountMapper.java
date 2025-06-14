package com.felfire.project.mapper;

import com.felfire.project.dto.BankAccountDTO;
import com.felfire.project.dto.BankAccountListDTO;
import com.felfire.project.entity.BankAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BankAccountMapper {

    public BankAccount toEntity(BankAccountDTO dto) {
        BankAccount entity = new BankAccount();
        entity.setAccountNumber(dto.getAccountNumber());
        entity.setAccountScore(dto.getAccountScore());
        return entity;
    }

    public BankAccountDTO toDTO(BankAccount entity) {
        BankAccountDTO dto = new BankAccountDTO();
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setAccountScore(entity.getAccountScore());
        return dto;
    }

    public BankAccountListDTO listOfDTO(List<BankAccount> entity) {
        BankAccountListDTO bankAccountListDTO = new BankAccountListDTO();
        List<BankAccountDTO> list = new ArrayList<>(entity.size());
        double amount = 0.0;
        for (BankAccount e : entity) {
            amount += e.getAccountScore();
            list.add(toDTO(e));
        }
        bankAccountListDTO.setAccounts(list);
        bankAccountListDTO.setAmount(amount);
        return bankAccountListDTO;
    }

}
