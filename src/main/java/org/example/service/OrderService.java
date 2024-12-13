package org.example.service;

import org.example.model.Order;

import java.util.List;

public interface OrderService {

    Order save(Integer customerId, List<Integer> pizzaIds);

    List<Order> findAll();

    Order findById(Integer id);

    Order update(Integer orderId, Integer customerId, List<Integer> pizzaIds);

    void delete(Integer id);
}
