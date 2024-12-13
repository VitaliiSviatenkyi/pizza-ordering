package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.exception.EntityNotFoundException;
import org.example.exception.ProductNotFoundException;
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

@Primary
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final PizzaRepository pizzaRepository;

    @Override
    public Order save(Integer customerId, List<Integer> pizzaIds) {
        if (pizzaIds == null || pizzaIds.isEmpty()) {
            throw new ProductNotFoundException("Pizza IDs list must not be null or empty");
        }
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        List<Pizza> pizzas = pizzaRepository.findAllById(pizzaIds);
        if (pizzas.isEmpty()) {
            throw new EntityNotFoundException("No pizzas found for the given IDs");
        }
        Order order = Order.builder()
                .customer(customer)
                .pizzaList(pizzas)
                .creationDate(LocalDateTime.now())
                .build();

        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    @Override
    public Order update(Integer orderId, Integer customerId, List<Integer> pizzaIds) {
        Order updateOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        updateOrder.setCustomer(customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found")));
        updateOrder.setPizzaList(pizzaRepository.findAllById(pizzaIds));
        return orderRepository.save(updateOrder);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}
