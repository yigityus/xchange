package com.payd.xchange.model;

import java.time.OffsetDateTime;

public record ExchangeConvert(String source, String target, Double rate,
                              Double amount, Double convertedAmount, String trxId, OffsetDateTime dateTime) {
    public ExchangeConvert withConvertedAmountAndRateAndTrxId(
            Double convertedAmount, Double rate, String trxId) {
        return new ExchangeConvert(source(), target(), rate, amount(), convertedAmount, trxId, dateTime());
    }
}
