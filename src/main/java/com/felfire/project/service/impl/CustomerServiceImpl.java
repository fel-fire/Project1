package com.felfire.project.service.impl;

import com.felfire.project.entity.Customer;
import com.felfire.project.exception.NoSuchEntityFound;
import com.felfire.project.repository.CustomerRepo;
import com.felfire.project.service.CustomerService;
import com.felfire.project.service.LoggedUserManagementService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    private final LoggedUserManagementService loggedUserManagementService;

    public Customer getCurrentCustomer() {
        return customerRepo.findById(loggedUserManagementService.getId()).orElseThrow(
                () -> new NoSuchEntityFound("Пользователь с id: " + loggedUserManagementService.getId() + " не найден"));
    }

    @Override
    public Customer register(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getByPasport(String passport) {
        return customerRepo.findByPassport(passport).orElseThrow(
                () -> new NoSuchEntityFound("Пользователь с паспортом " + passport + " отсутствует в системе")
        );
    }

    @Override
    public void delete(Integer id) {
        customerRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void update(Customer customer) {
        customerRepo.findById(customer.getId()).orElseThrow(
                () -> new NoSuchEntityFound("Пользователь с id: " + customer.getId() + " не найден"));
        customerRepo.save(customer);

    }
}
