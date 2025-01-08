package com.payd.xchange.model;

public record ExchangeRate(String source, String target, Double rate) {
    public ExchangeRate withRate(Double rate) {
        return new ExchangeRate(source(), target(), rate);
    }
}
