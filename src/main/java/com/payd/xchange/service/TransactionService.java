package com.payd.xchange.service;

import com.payd.xchange.model.ExchangeDto;

public interface TransactionService {
    ExchangeDto save(ExchangeDto dto);
}
