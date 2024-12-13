package org.example.web.controller;

import org.example.facade.CustomerFacade;
import org.example.web.dto.CreateCustomerDto;
import org.example.web.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable Integer id) {
        return customerFacade.findById(id);
    }

    @PutMapping
    public CustomerDto update(@RequestBody CustomerDto customerDto) {
        return customerFacade.update(customerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customerFacade.delete(id);
    }
}
