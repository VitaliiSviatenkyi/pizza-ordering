package org.example.service.impl;

import org.example.AbstractUnitTest;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplUnitTest extends AbstractUnitTest {

    @Mock
    private CustomerRepository customerRepositoryMock;

    @InjectMocks
    private CustomerServiceImpl sut;

    @Test
    void saveAndReturnCustomer() {
        //given
        Customer expected = customer;
        when(customerRepositoryMock.save(expected)).thenReturn(expected);
        //when
        Customer actual = sut.save(expected);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void findAllCustomerAndReturnInList() {
        //given
        List<Customer> expectedList = List.of(customer, customer);
        when(customerRepositoryMock.findAll()).thenReturn(expectedList);
        //when
        List<Customer> actualList = sut.findAll();
        //then
        assertEquals(expectedList, actualList);
    }
}