package com.felfire.project.service;

import com.felfire.project.entity.BankAccount;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Сервис для управления банковскими счетами. Предоставляет возможность получить список всех счетов, открыть новый
 * банковский счет для текущего пользователя, а также закрыть существующий банковский счет.
 */
@Service
public interface BankAccountService {

    List<BankAccount> getAccounts();
    BankAccount openAccount();
    void closeAccount(Integer accountNumber);
    void reset();
}
