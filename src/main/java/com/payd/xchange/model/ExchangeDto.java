package com.payd.xchange.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@Validated
public class ExchangeDto {
    @NonNull
    private String source;
    @NonNull
    private String target;
    private Double rate;
    private Double amount;
    @Getter(AccessLevel.NONE)
    private Double convertedAmount;
    private String transactionId;
    private LocalDateTime created;

    public Double getConvertedAmount() {
        if (Objects.isNull(amount)) {
            return null;
        }
        return amount * rate;
    }
}
