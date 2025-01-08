package com.payd.xchange.service;

import com.payd.xchange.model.ExchangeDto;

public interface ExchangeService {
    ExchangeDto exchange(ExchangeDto exchangeDto);
    ExchangeDto convert(ExchangeDto exchangeConvertDto);
}
