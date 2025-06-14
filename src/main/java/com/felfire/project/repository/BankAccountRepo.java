package com.felfire.project.repository;

import com.felfire.project.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepo extends CrudRepository<BankAccount, Integer> {
    Iterable<BankAccount> findByAccountOwner(int accountOwner);

    Optional<BankAccount> findFirstByAccountOwnerIsNull();

    Optional<BankAccount> findByAccountNumber(Integer accountNumber);
}
