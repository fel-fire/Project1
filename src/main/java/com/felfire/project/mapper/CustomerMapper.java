package com.felfire.project.mapper;


import com.felfire.project.dto.CustomerDTO;
import com.felfire.project.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setLastname(customer.getLastname());
        customerDTO.setFirstname(customer.getFirstname());
        customerDTO.setPassport(customer.getPassport());
        customerDTO.setPatronimyc(customer.getPatronimyc());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setTown(customer.getTown());
        customerDTO.setUsername(customer.getUsername());
        return customerDTO;
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setLastname(customerDTO.getLastname());
        customer.setFirstname(customerDTO.getFirstname());
        customer.setPassport(customerDTO.getPassport());
        customer.setPatronimyc(customerDTO.getPatronimyc());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setTown(customerDTO.getTown());
        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customerDTO.getPassword());
        return customer;
    }
}
