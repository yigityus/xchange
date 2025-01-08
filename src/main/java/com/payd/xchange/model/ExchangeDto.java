package com.payd.xchange.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
public class ExchangeDto {
    private String source;
    private String target;
    private Double rate;
    private Double amount;
    @Getter(AccessLevel.NONE)
    private Double convertedAmount;
    private String transactionId;
    private OffsetDateTime dateTime;

    public Double getConvertedAmount() {
        if (Objects.isNull(amount)) {
            return null;
        }
        return amount * rate;
    }
}
