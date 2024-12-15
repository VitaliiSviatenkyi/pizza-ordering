package org.example.facade.impl;

import org.example.AbstractUnitTest;
import org.example.model.Customer;
import org.example.service.CustomerService;
import org.example.web.dto.CreateCustomerDto;
import org.example.web.dto.CustomerDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerFacadeImplUnitTest extends AbstractUnitTest {

    @Mock
    private CustomerService customerServiceMock;
    @Mock
    private ConversionService conversionServiceMock;
    @InjectMocks
    private CustomerFacadeImpl sut;

    @Test
    void saveAndReturnCustomerDto() {
        //given
        CreateCustomerDto createCustomerDto = CreateCustomerDto.builder().name(name).address(address).build();
        Customer expected = customer;
        CustomerDto expectedDto = customerDto;
        when(conversionServiceMock.convert(createCustomerDto, Customer.class)).thenReturn(expected);
        when(customerServiceMock.save(expected)).thenReturn(expected);
        when(conversionServiceMock.convert(expected, CustomerDto.class)).thenReturn(expectedDto);
        //when
        CustomerDto actualDto = sut.save(createCustomerDto);
        //then
        assertEquals(expectedDto, actualDto);
    }

    @Test
    void findAllCustomerDtoAndReturnInList() {
        //given
        Customer expected = customer;
        CustomerDto expectedDto = customerDto;
        List<Customer> expectedList = List.of(expected, expected);
        List<CustomerDto> expectedDtoList = List.of(expectedDto, expectedDto);
        when(customerServiceMock.findAll()).thenReturn(expectedList);
        when(conversionServiceMock.convert(expected, CustomerDto.class)).thenReturn(expectedDto);
        //when
        List<CustomerDto> actualDtoList = sut.findAll();
        //then
        assertEquals(expectedDtoList, actualDtoList);
    }
}