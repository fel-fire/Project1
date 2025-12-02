package com.felfire.project.controller.impl;

import com.felfire.project.controller.BankAccountController;
import com.felfire.project.dto.BankAccountDTO;
import com.felfire.project.dto.BankAccountListDTO;
import com.felfire.project.mapper.BankAccountMapper;
import com.felfire.project.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class BankAccountControllerImpl implements BankAccountController {
    
    private final BankAccountService service;
    private final BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountListDTO getAccountsList() {
        return bankAccountMapper.listOfDTO(service.getAccounts());
    }

    @Override
    public ResponseEntity<BankAccountDTO> openAccount() {
        service.openAccount();
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/startpage.html"))
                .build();
    }

    @Override
    public ResponseEntity<Void> closeAccount(Integer accountNumber) {
        service.closeAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/startpage.html"))
                .build();
    }


}
