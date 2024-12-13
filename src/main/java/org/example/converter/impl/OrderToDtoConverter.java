package org.example.converter.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Order;
import org.example.web.dto.OrderDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderToDtoConverter implements Converter<Order, OrderDto> {

    private final CustomerToDtoConverter customerToDtoConverter;
    private final PizzaToDtoConverter pizzaToDtoConverter;

    @Override
    public OrderDto convert(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .customerDto(customerToDtoConverter.convert(order.getCustomer()))
                .pizzaDtoList(order.getPizzaList().stream()
                        .map(pizzaToDtoConverter::convert).collect(Collectors.toList()))
                .creationDate(order.getCreationDate())
                .build();
    }
}
