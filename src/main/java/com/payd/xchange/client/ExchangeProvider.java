package com.payd.xchange.client;

import com.payd.xchange.model.ExchangeRate;

public interface ExchangeProvider {
    ExchangeRate exchange(ExchangeRate exchangeRate);
}
