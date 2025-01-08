package com.payd.xchange.model;

public record ExchangeConvert(String source, String target, Double amount, Double convertedAmount, String id) {
    public ExchangeConvert with(Double amount, String id) {
        return new ExchangeConvert(source(), target, amount(), amount, id);
    }
}
