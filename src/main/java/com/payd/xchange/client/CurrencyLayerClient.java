package com.payd.xchange.client;

import com.payd.xchange.model.ProviderExchange;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "${exchange.provider.url}", contentType = "application/json")
public interface CurrencyLayerClient {
    @GetExchange("/live?access_key=${exchange.provider.accesskey}&format=1")
    ProviderExchange live(@RequestParam("currencies") String currency, @RequestParam String source);
}
