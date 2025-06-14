package com.felfire.project.service;

import com.felfire.project.entity.BankAccount;
import com.felfire.project.repository.BankAccountRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

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
