package org.example.facade.impl;

import org.example.AbstractUnitTest;
import org.example.model.Order;
import org.example.service.OrderService;
import org.example.web.dto.OrderDto;
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
class OrderFacadeImplUnitTest extends AbstractUnitTest {

    @Mock
    private OrderService orderServiceMock;
    @Mock
    private ConversionService conversionServiceMock;
    @InjectMocks
    private OrderFacadeImpl sut;

    @Test
    void saveAndReturnOrderDto() {
        //given
        Order expected = order;
        OrderDto expectedDto = orderDto;
        when(orderServiceMock.save(expectedDto.getCustomerDto().getId(),
                List.of(expectedDto.getPizzaDtoList().size()))).thenReturn(expected);
        when(conversionServiceMock.convert(expected, OrderDto.class)).thenReturn(expectedDto);
        //when
        OrderDto actualDto = sut.save(expectedDto.getCustomerDto().getId(),
                List.of(expectedDto.getPizzaDtoList().size()));
        //then
        assertEquals(expectedDto, actualDto);
    }
}