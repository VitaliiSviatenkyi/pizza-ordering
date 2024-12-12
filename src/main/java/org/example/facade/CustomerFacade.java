package org.example.facade;

import org.example.web.dto.CreateCustomerDto;
import org.example.web.dto.CustomerDto;

import java.util.List;

public interface CustomerFacade {

    CustomerDto save(CreateCustomerDto createCustomerDto);

    List<CustomerDto> findAll();
}
