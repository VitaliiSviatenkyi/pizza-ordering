package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.exception.EntityNotFoundException;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    @Override
    public Customer update(Customer customer) {
        Customer updateCustomer = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        updateCustomer.setName(customer.getName());
        updateCustomer.setAddress(customer.getAddress());
        return customerRepository.save(updateCustomer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
