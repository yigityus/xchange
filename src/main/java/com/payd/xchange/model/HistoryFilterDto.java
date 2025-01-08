package com.payd.xchange.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryFilterDto {
    private String transactionId;
    private LocalDateTime date;
}
