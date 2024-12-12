package org.example.service;

import org.example.model.Order;

import java.util.List;

public interface OrderService {

    Order save(Integer customerId, List<Integer> pizzaIds);
}
