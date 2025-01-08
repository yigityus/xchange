package com.payd.xchange.client;

import com.payd.xchange.model.ExchangeRate;
import com.payd.xchange.model.ProviderExchange;
import org.springframework.stereotype.Service;

@Service
public class ExchangeProviderImpl implements ExchangeProvider {

    private final CurrencyLayerClient currencyLayerClient;

    public ExchangeProviderImpl(CurrencyLayerClient currencyLayerClient) {
        this.currencyLayerClient = currencyLayerClient;
    }

    @Override
    public ExchangeRate exchange(ExchangeRate exchangeRate) {
        ProviderExchange providerExchange = currencyLayerClient.live(exchangeRate.target(), exchangeRate.source());
        ExchangeRate liveExchangeRate = new ExchangeRate(exchangeRate.source(), exchangeRate.target(),
                providerExchange.quotes().values().iterator().next());
        return liveExchangeRate;
    }
}
