package org.example.converter.impl;

import org.example.model.Customer;
import org.example.web.dto.CreateCustomerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerDtoToCustomerConverter implements Converter<CreateCustomerDto, Customer> {

    @Override
    public Customer convert(CreateCustomerDto createCustomerDto) {
        return Customer.builder()
                .name(createCustomerDto.getName())
                .address(createCustomerDto.getAddress())
                .build();
    }
}
