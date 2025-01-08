package com.payd.xchange.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "${exchange.provider.currencylayer.url}", contentType = "application/json")
public interface CurrencyLayerClient {
    @GetExchange("/live?access_key=${exchange.provider.currencylayer.accesskey}&format=1")
    String live(@RequestParam("currencies") String currency, @RequestParam String source);
}
