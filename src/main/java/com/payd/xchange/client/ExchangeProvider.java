package com.payd.xchange.client;

import com.payd.xchange.model.ExchangeDto;

public interface ExchangeProvider {
    ExchangeDto exchange(ExchangeDto exchangeDto);
}
