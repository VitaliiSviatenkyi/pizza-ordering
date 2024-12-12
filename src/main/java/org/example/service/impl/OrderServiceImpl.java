package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.Pizza;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderRepository;
import org.example.repository.PizzaRepository;
import org.example.service.OrderService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Primary
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final PizzaRepository pizzaRepository;

    @Override
    public Order save(Integer customerId, List<Integer> pizzaIds) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }

        List<Pizza> pizzas = pizzaRepository.findAllById(pizzaIds);
        if (pizzas.isEmpty()) {
            throw new RuntimeException("No pizzas found for the given IDs");
        }

        Order order = Order.builder()
                .customer(customer.get())
                .pizzaList(pizzas)
                .creationDate(LocalDateTime.now())
                .build();

        return orderRepository.save(order);

    }
}
