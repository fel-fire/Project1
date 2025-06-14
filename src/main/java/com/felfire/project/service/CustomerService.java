package com.felfire.project.service;

import com.felfire.project.entity.Customer;
import org.springframework.stereotype.Service;

/**
 * Сервис для управления пользователями. Предоставляет получить объект текущего пользователя.
 */
@Service
public interface CustomerService {
    Customer getCurrentCustomer();

    Customer register(Customer customer);

    Customer getByPasport(String passport);

    void delete(Integer id);

    void update(Customer customer);
}
