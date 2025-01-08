package com.payd.xchange.client;

import com.payd.xchange.model.ExchangeDto;
import com.payd.xchange.model.ProviderExchange;
import org.springframework.stereotype.Service;

@Service
public class ExchangeProviderImpl implements ExchangeProvider {

    private final CurrencyLayerClient currencyLayerClient;

    public ExchangeProviderImpl(CurrencyLayerClient currencyLayerClient) {
        this.currencyLayerClient = currencyLayerClient;
    }

    @Override
    public ExchangeDto exchange(ExchangeDto dto) {
        ProviderExchange providerExchange = currencyLayerClient.live(dto.getTarget(), dto.getSource());
        if (providerExchange.success()) {
            dto.setRate(providerExchange.quotes().values().iterator().next());
            return dto;
        }

        throw new IllegalArgumentException("Please provide accurate currency!");
    }
}
