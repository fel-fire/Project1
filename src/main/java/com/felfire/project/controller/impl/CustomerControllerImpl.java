package com.felfire.project.controller.impl;


import com.felfire.project.controller.CustomerController;
import com.felfire.project.dto.CustomerDTO;
import com.felfire.project.mapper.CustomerMapper;
import com.felfire.project.entity.Customer;
import com.felfire.project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CustomerControllerImpl implements CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;


    public CustomerDTO getCurrent() {
        Customer user = customerService.getCurrentCustomer();
        return customerMapper.toDTO(user);
    }

    @Override
    public ResponseEntity<?> register(CustomerDTO dto) {
        customerService.register(customerMapper.toEntity(dto));
        return ResponseEntity.ok(Map.of("message" , "Пользователь зарегистрирован"));
    }

    @Override
    public CustomerDTO getByPassport(String passport) {
        Customer customer = customerService.getByPasport(passport);
        return customerMapper.toDTO(customer);
    }

    @Override
    public void delete(Integer id) {
        customerService.delete(id);
    }

    @Override
    public ResponseEntity<?> update(CustomerDTO dto) {
        customerService.update(customerMapper.toEntity(dto));
        return ResponseEntity.ok(Map.of("message" , "Сведения о пользователе обновлены"));
    }
}
