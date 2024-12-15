package org.example.web.controller;

import org.example.AbstractUnitTest;
import org.example.facade.OrderFacade;
import org.example.web.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerUnitTest extends AbstractUnitTest {

    @Mock
    private OrderFacade orderFacadeMock;

    @InjectMocks
    private OrderController sut;

    @Test
    void saveAndReturnOrderDto() {
        //given
        OrderDto expectedDto = orderDto;
        when(orderFacadeMock.save(expectedDto.getCustomerDto().getId(),
                List.of(expectedDto.getPizzaDtoList().size()))).thenReturn(expectedDto);
        //when
        OrderDto actualDto = sut.save(expectedDto.getCustomerDto().getId(),
                List.of(expectedDto.getPizzaDtoList().size()));
        //then
        assertEquals(expectedDto, actualDto);
    }
}