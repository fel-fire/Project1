package com.felfire.project.mapper;

import com.felfire.project.dto.TransferDTO;
import com.felfire.project.entity.BankAccount;
import com.felfire.project.entity.Transfer;
import com.felfire.project.service.LoggedUserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TransferMapper {
    private final LoggedUserManagementService loggedUserManagementService;

    public TransferDTO toDTO(Transfer entity) {
        TransferDTO dto = new TransferDTO();
        dto.setTime(entity.getTransferTime());
        dto.setFrom(entity.getTransferFrom());
        dto.setTo(entity.getTransferTo());
        dto.setAmount(entity.getTransferAmount());
        return dto;
    }

    public Transfer map(BankAccount entityFrom, BankAccount entityTo, Double amount) {
        Transfer entity = new Transfer();
        entity.setTransferOwner(loggedUserManagementService.getId());
        entity.setTransferTime(LocalDateTime.now());
        entity.setTransferFrom(entityFrom.getAccountNumber());
        entity.setTransferTo(entityTo.getAccountNumber());
        entity.setTransferAmount(amount);
        return entity;
    }
}
