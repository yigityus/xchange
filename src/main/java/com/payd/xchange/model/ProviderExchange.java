package com.payd.xchange.model;

import java.time.Instant;
import java.util.Map;

public record ProviderExchange(boolean success, String terms, String privacy, Instant timestamp,
                               String source, Map<String, Double> quotes) {
}
