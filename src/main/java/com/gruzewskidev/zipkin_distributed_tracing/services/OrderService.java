package com.gruzewskidev.zipkin_distributed_tracing.services;

import com.gruzewskidev.zipkin_distributed_tracing.model.Order;
import com.gruzewskidev.zipkin_distributed_tracing.model.OrderStatus;
import com.gruzewskidev.zipkin_distributed_tracing.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final RestClient restClient;

    public OrderService(RestClient restClient) {
        this.restClient = restClient;
    }

    public OrderStatus createOrder(Order order) {
        UUID orderId = UUID.randomUUID();
        logger.info("Creating order with id: {}", orderId);
        String paymentUrl = getPaymentUrl(UUID.randomUUID(), order.price());
        return new OrderStatus(orderId, Status.PROCESSING, paymentUrl);
    }

    private String getPaymentUrl(UUID id, BigDecimal amount) {
        return restClient.post()
                .uri("http://localhost:8081/api/payment")
                .body(new PaymentReq(id, amount))
                .retrieve()
                .body(String.class);
    }

    record PaymentReq(UUID id, BigDecimal amount) {}
}
