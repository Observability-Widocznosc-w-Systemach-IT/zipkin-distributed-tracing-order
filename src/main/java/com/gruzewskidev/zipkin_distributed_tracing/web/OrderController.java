package com.gruzewskidev.zipkin_distributed_tracing.web;

import com.gruzewskidev.zipkin_distributed_tracing.model.Order;
import com.gruzewskidev.zipkin_distributed_tracing.model.OrderStatus;
import com.gruzewskidev.zipkin_distributed_tracing.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderStatus createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }


}
