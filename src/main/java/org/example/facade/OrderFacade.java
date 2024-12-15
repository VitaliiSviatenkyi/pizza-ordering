package org.example.facade;

import org.example.web.dto.OrderDto;

import java.util.List;

public interface OrderFacade {

    OrderDto save(Integer customerId, List<Integer> pizzaIds);

    List<OrderDto> findAll();

    OrderDto findById(Integer id);

    OrderDto update(Integer orderId, Integer customerId, List<Integer> pizzaIds);

    void delete(Integer id);
}
