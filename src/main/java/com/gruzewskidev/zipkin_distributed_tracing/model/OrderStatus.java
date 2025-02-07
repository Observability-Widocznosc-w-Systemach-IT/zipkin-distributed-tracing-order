package com.gruzewskidev.zipkin_distributed_tracing.model;

import java.util.UUID;

public record OrderStatus(UUID id, Status status, String paymentUrl) {
}
