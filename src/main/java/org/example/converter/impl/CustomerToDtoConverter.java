package org.example.converter.impl;

import org.example.model.Customer;
import org.example.web.dto.CustomerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToDtoConverter implements Converter<Customer, CustomerDto> {

    @Override
    public CustomerDto convert(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .address(customer.getAddress())
                .build();
    }
}
