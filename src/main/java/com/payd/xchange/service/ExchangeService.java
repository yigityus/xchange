package com.payd.xchange.service;

import com.payd.xchange.model.ExchangeConvert;
import com.payd.xchange.model.ExchangeRate;

public interface ExchangeService {
    ExchangeRate exchange(ExchangeRate exchangeRate);
    ExchangeConvert convert(ExchangeConvert exchangeConvert);
}
