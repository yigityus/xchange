package com.payd.xchange.config;

import com.payd.xchange.client.CurrencyLayerClient;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringValueResolver;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ExchangeClientConfig {

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
