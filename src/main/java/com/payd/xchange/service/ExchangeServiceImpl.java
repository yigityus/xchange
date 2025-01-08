package com.payd.xchange.service;

import com.payd.xchange.client.ExchangeProvider;
import com.payd.xchange.model.ExchangeRate;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeProvider exchangeProvider;

    public ExchangeServiceImpl(ExchangeProvider exchangeProvider) {
        this.exchangeProvider = exchangeProvider;
    }

    @Override
    public ExchangeRate exchange(ExchangeRate exchangeRate) {
        return exchangeProvider.exchange(exchangeRate);
    }

}
