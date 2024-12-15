package org.example.web.controller;

import org.example.AbstractUnitTest;
import org.example.facade.CustomerFacade;
import org.example.web.dto.CreateCustomerDto;
import org.example.web.dto.CustomerDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerUnitTest extends AbstractUnitTest {

    @Mock
    private CustomerFacade customerFacadeMock;

    @InjectMocks
    private CustomerController sut;

    @Test
    void saveAndReturnCustomerDto() {
        //given
        CreateCustomerDto createCustomerDto = CreateCustomerDto.builder().name(name).address(address).build();
        CustomerDto expected = customerDto;
        when(customerFacadeMock.save(createCustomerDto)).thenReturn(expected);
        //when
        CustomerDto actual = sut.save(createCustomerDto);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void findAllCustomerDtoAndReturnInList() {
        //given
        List<CustomerDto> expectedList = List.of(customerDto);
        when(customerFacadeMock.findAll()).thenReturn(expectedList);

        //when
        List<CustomerDto> actualList = sut.findAll();

        //then
        assertEquals(expectedList, actualList);
    }
}