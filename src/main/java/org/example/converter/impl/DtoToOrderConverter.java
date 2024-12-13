package org.example.converter.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Order;
import org.example.web.dto.OrderDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DtoToOrderConverter implements Converter<OrderDto, Order> {

    private final DtoToCustomerConverter dtoToCustomerConverter;
    private final DtoToPizzaConverter dtoToPizzaConverter;

    @Override
    public Order convert(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .customer(dtoToCustomerConverter.convert(orderDto.getCustomerDto()))
                .pizzaList(orderDto.getPizzaDtoList().stream()
                        .map(dtoToPizzaConverter::convert).collect(Collectors.toList()))
                .creationDate(orderDto.getCreationDate())
                .build();
    }
}
