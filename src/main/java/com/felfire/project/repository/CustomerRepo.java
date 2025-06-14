package com.felfire.project.repository;

import com.felfire.project.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

    Optional<Customer> findByUsername(String username);

    Optional<Customer> findByPassport(String passport);
}
