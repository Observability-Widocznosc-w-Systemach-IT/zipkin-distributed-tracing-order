package com.gruzewskidev.zipkin_distributed_tracing.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record Order(List<UUID> productIds, int quantity, BigDecimal price) {}
