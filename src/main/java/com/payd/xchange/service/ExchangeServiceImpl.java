package com.payd.xchange.service;

import com.payd.xchange.client.ExchangeProvider;
import com.payd.xchange.model.ExchangeConvert;
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

    @Override
    public ExchangeConvert convert(ExchangeConvert exchangeConvert) {
        return exchangeConvert.with(exchangeConvert.amount() * rate(exchangeConvert), "TRX");
    }

    private Double rate(ExchangeConvert exchangeConvert) {
        ExchangeRate exchangeRate = new ExchangeRate(exchangeConvert.source(), exchangeConvert.target(), null);
        return exchangeProvider.exchange(exchangeRate).rate();
    }

}
