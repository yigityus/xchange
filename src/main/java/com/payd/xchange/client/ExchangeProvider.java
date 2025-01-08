package com.payd.xchange.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringValueResolver;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Service
public class ExchangeProvider {

    @Bean
    RestClient restClient(RestClient.Builder builder) {
        return builder.build();
    }

    @Bean
    public StringValueResolver stringValueResolver(ConfigurableBeanFactory factory) {
        return new EmbeddedValueResolver(factory);
    }

    @Bean
    CurrencyLayerClient currencyLayerClient(RestClient restClient, StringValueResolver stringValueResolver) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(
                RestClientAdapter.create(restClient)
        ).embeddedValueResolver(stringValueResolver::resolveStringValue)
                .build();
        return factory.createClient(CurrencyLayerClient.class);
    }

}
