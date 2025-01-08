package com.payd.xchange.service;

import com.payd.xchange.client.ExchangeProvider;
import com.payd.xchange.model.ExchangeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeProvider exchangeProvider;
    private final TransactionService transactionService;

    @Override
    public ExchangeDto exchange(ExchangeDto exchangeDto) {
        return exchangeProvider.exchange(exchangeDto);
    }

    @Override
    public ExchangeDto convert(ExchangeDto exchangeDto) {
        exchangeDto.setRate(exchangeProvider.exchange(exchangeDto).getRate());
        return transactionService.save(exchangeDto);
    }

}
