package org.example.web.controller;

import org.example.facade.CustomerFacade;
import org.example.web.dto.CreateCustomerDto;
import org.example.web.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;

    @PostMapping
    public CustomerDto save(@RequestBody CreateCustomerDto createCustomerDto) {
        return customerFacade.save(createCustomerDto);
    }

    @GetMapping
    public List<CustomerDto> findAll() {
        return customerFacade.findAll();
    }
}
