package org.example.converter.impl;

import org.example.model.Customer;
import org.example.web.dto.CustomerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToCustomerConverter implements Converter<CustomerDto, Customer> {

    @Override
    public Customer convert(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .address(customerDto.getAddress())
                .build();
    }
}
