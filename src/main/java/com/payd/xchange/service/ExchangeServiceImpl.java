package com.payd.xchange.service;

import com.payd.xchange.client.ExchangeProvider;
import com.payd.xchange.model.ExchangeConvert;
import com.payd.xchange.model.ExchangeRate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeProvider exchangeProvider;
    private final TransactionService transactionService;

    public ExchangeServiceImpl(ExchangeProvider exchangeProvider, TransactionService transactionService) {
        this.exchangeProvider = exchangeProvider;
        this.transactionService = transactionService;
    }

    @Override
    public ExchangeRate exchange(ExchangeRate exchangeRate) {
        return exchangeProvider.exchange(exchangeRate);
    }

    @Override
    public ExchangeConvert convert(ExchangeConvert exchangeConvert) {
        String trxId = UUID.randomUUID().toString();
        Double rate = fetchRate(exchangeConvert);
        Double convertedAmount = exchangeConvert.amount() * rate;
        ExchangeConvert trx = exchangeConvert
                .withConvertedAmountAndRateAndTrxId(
                        convertedAmount, rate, trxId);

        return transactionService.save(trx);
    }

    private Double fetchRate(ExchangeConvert exchangeConvert) {
        ExchangeRate exchangeRate = new ExchangeRate(exchangeConvert.source(), exchangeConvert.target(), null);
        return exchangeProvider.exchange(exchangeRate).rate();
    }

}
