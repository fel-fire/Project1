package com.felfire.project.service.impl;

import com.felfire.project.annotation.Mutator;
import com.felfire.project.annotation.MyCache;
import com.felfire.project.entity.BankAccount;
import com.felfire.project.exception.InvalidScoreValue;
import com.felfire.project.exception.NoSuchEntityFound;
import com.felfire.project.repository.BankAccountRepo;
import com.felfire.project.service.BankAccountService;
import com.felfire.project.service.LoggedUserManagementService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@MyCache("getAccounts")
@NoArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepo bankAccountRepo;
    private LoggedUserManagementService loggedUserManagementService;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepo bankAccountRepo, LoggedUserManagementService loggedUserManagementService) {
        this.bankAccountRepo = bankAccountRepo;
        this.loggedUserManagementService = loggedUserManagementService;
    }


    public List<BankAccount> getAccounts() {
        List<BankAccount> accounts = new ArrayList<>();
        bankAccountRepo.findByAccountOwner(loggedUserManagementService.getId()).forEach(accounts::add);
        return accounts;
    }

    @Mutator
    public BankAccount openAccount() {
        BankAccount entity = bankAccountRepo.findFirstByAccountOwnerIsNull().orElseThrow(
                () -> new NoSuchEntityFound("Невозможно открыть новый банковский счет. " +
                        "В базе банковских счетов отсутствуют счета, доступные для открытия в настоящий момент"));
        entity.setAccountOwner(loggedUserManagementService.getId());
        bankAccountRepo.save(entity);
        return entity;
    }

    @Mutator
    public void closeAccount(Integer accountNumber) {
            BankAccount entity = bankAccountRepo.findByAccountNumber(accountNumber).orElseThrow(
                    () -> new NoSuchEntityFound("Не найден банковский счет с номером " + accountNumber));
            if (entity.getAccountScore() > 0)
                throw new InvalidScoreValue("Невозможно закрыть счет. Для закрытия счета необходимо, " +
                        "чтобы его баланс был равен 0");
            entity.setAccountOwner(null);
            bankAccountRepo.save(entity);
    }

    @Override
    @Mutator
    public void reset() {

    }
}
