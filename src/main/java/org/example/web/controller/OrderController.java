package org.example.web.controller;

import org.example.facade.OrderFacade;
import org.example.web.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderFacade orderFacade;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public OrderDto save(@RequestParam Integer customerId, @RequestParam List<Integer> pizzaIds) {
        return orderFacade.save(customerId, pizzaIds);
    }

    @GetMapping
    public List<OrderDto> findAll() {
        return orderFacade.findAll();
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Integer id) {
        return orderFacade.findById(id);
    }

    @PutMapping
    public OrderDto update(@RequestParam Integer orderId,
                           @RequestParam Integer customerId,
                           @RequestParam List<Integer> pizzaIds) {
        return orderFacade.update(orderId, customerId, pizzaIds);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orderFacade.delete(id);
    }
}
