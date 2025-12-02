package com.felfire.project.controller.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.felfire.project.dto.BankAccountDTO;
import com.felfire.project.dto.BankAccountListDTO;
import com.felfire.project.entity.BankAccount;
import com.felfire.project.mapper.BankAccountMapper;
import com.felfire.project.service.BankAccountService;

@ExtendWith(MockitoExtension.class)
public class BankAccountControllerImplTest {

    @Mock
    BankAccountService service;

    @Mock
    BankAccountMapper mapper;

    @InjectMocks
    BankAccountControllerImpl bankAccountController;

    @Test
    @DisplayName("closeAccount() должен вернуть ответ со статусом FOUND и заголовком location \"/startpage.html\"")
    void testCloseAccount() {
        // given
        Mockito.doNothing().when(service).closeAccount(1);

        // when
        ResponseEntity<Void> result = bankAccountController.closeAccount(1);
        // then
        assertEquals(HttpStatus.FOUND, result.getStatusCode());
        assertEquals("/startpage.html",
                result.getHeaders().getLocation().toString());
        Mockito.verify(service).closeAccount(1);
        Mockito.verifyNoMoreInteractions(service);
    }

    @Test
    @DisplayName("getAccountsList() должен вернуть BankAccountListDTO")
    void testGetAccountsList() {

        // given
        List<BankAccount> accounts = List.of(new BankAccount(), new BankAccount());
        BankAccountListDTO listOfDTO = new BankAccountListDTO();
        doReturn(accounts).when(service).getAccounts();
        doReturn(listOfDTO).when(mapper).listOfDTO(accounts);
        // when
        var result = bankAccountController.getAccountsList();
        // then
        assertEquals(listOfDTO, result);
        Mockito.verify(service).getAccounts();
        Mockito.verify(mapper).listOfDTO(accounts);
        Mockito.verifyNoMoreInteractions(service, mapper);

    }

    @Test
    @DisplayName("openAccount() должен вернуть ответ со статусом FOUND и заголовком location \"/startpage.html\"")
    void testOpenAccount() {
        // given

        Mockito.doReturn(new BankAccount()).when(service).openAccount();

        // when
        ResponseEntity<BankAccountDTO> result = bankAccountController.openAccount();
        // then
        assertEquals(HttpStatus.FOUND, result.getStatusCode());
        assertEquals("/startpage.html",
                result.getHeaders().getLocation().toString());
        Mockito.verify(service).openAccount();
        Mockito.verifyNoMoreInteractions(service);
    }
}
