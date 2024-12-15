package org.example.facade.impl;

import lombok.RequiredArgsConstructor;
import org.example.facade.CustomerFacade;
import org.example.model.Customer;
import org.example.service.CustomerService;
import org.example.web.dto.CreateCustomerDto;
import org.example.web.dto.CustomerDto;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerFacadeImpl implements CustomerFacade {

    private final CustomerService customerService;
    private final ConversionService conversionService;

    @Override
    public CustomerDto save(CreateCustomerDto createCustomerDto) {
        Customer customer = conversionService.convert(createCustomerDto, Customer.class);
        customer = customerService.save(customer);
        return conversionService.convert(customer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerService.findAll().stream().map(customer -> conversionService.convert(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto findById(Integer id) {
        Customer customer = customerService.findById(id);
        return conversionService.convert(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto update(CustomerDto customerDto) {
        Customer customer = conversionService.convert(customerDto, Customer.class);
        customer = customerService.update(customer);
        return conversionService.convert(customer, CustomerDto.class);
    }

    @Override
    public void delete(Integer id) {
        customerService.delete(id);
    }
}
