package org.example.service;

import org.example.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> findAll();
}
