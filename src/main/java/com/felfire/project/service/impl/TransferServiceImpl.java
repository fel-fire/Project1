package com.felfire.project.service.impl;

import com.felfire.project.entity.BankAccount;
import com.felfire.project.exception.InvalidScoreValue;
import com.felfire.project.exception.NoSuchEntityFound;
import com.felfire.project.mapper.TransferMapper;
import com.felfire.project.repository.BankAccountRepo;
import com.felfire.project.service.TransferHistorySaverService;
import com.felfire.project.service.TransferService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final BankAccountRepo bankAccountRepo;
    private final TransferMapper transferMapper;
    private final TransferHistorySaverService transferHistorySaverService;

    @Transactional
    public void transfer(Integer from, Integer to, Double amount) {
        BankAccount entityFrom = bankAccountRepo.findByAccountNumber(from).orElseThrow(
                () -> new NoSuchEntityFound("Банковский счет с номером " + from + " не найден"));
        BankAccount entityTo = bankAccountRepo.findByAccountNumber(to).orElseThrow(
                () -> new NoSuchEntityFound("Банковский счет с номером " + to + " не найден"));
        Double balanceFrom = entityFrom.getAccountScore();
        Double balanceTo = entityTo.getAccountScore();

        if (balanceFrom < amount) throw new InvalidScoreValue("Can't transfer. " +
                "Баланс счета " + from + " = " + balanceFrom + " меньше, чем переводимая сумма = " + amount);

        entityFrom.setAccountScore(balanceFrom - amount);
        entityTo.setAccountScore(balanceTo + amount);
        transferHistorySaverService.saveInHistory(transferMapper.map(entityFrom, entityTo, amount));
    }

}
