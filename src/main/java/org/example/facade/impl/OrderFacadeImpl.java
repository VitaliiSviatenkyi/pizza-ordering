package org.example.facade.impl;

import lombok.RequiredArgsConstructor;
import org.example.facade.OrderFacade;
import org.example.model.Order;
import org.example.service.OrderService;
import org.example.web.dto.OrderDto;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderFacadeImpl implements OrderFacade {

    private final OrderService orderService;
    private final ConversionService conversionService;

    @Override
    public OrderDto save(Integer customerId, List<Integer> pizzaIds) {
        Order order = orderService.save(customerId, pizzaIds);
        return conversionService.convert(order, OrderDto.class);
    }

    @Override
    public List<OrderDto> findAll() {
        return orderService.findAll().stream().map(order -> conversionService.convert(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Integer id) {
        Order order = orderService.findById(id);
        return conversionService.convert(order, OrderDto.class);
    }

    @Override
    public OrderDto update(Integer orderId, Integer customerId, List<Integer> pizzaIds) {
        Order order = orderService.update(orderId, customerId, pizzaIds);
        return conversionService.convert(order, OrderDto.class);
    }

    @Override
    public void delete(Integer id) {
        orderService.delete(id);
    }
}
