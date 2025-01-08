package com.payd.xchange.controller;

import com.payd.xchange.client.CurrencyLayerClient;
import com.payd.xchange.model.ProviderExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EchoController {

    private final CurrencyLayerClient currencyLayerClient;

    public EchoController(CurrencyLayerClient currencyLayerClient) {
        this.currencyLayerClient = currencyLayerClient;
    }

    @GetMapping("/echo")
    public EchoLog echo(@RequestParam String name) {

        ProviderExchange live = currencyLayerClient.live("EUR", "GBP");
        return new EchoLog(LocalDateTime.now(), name);
    }
    record EchoLog(LocalDateTime instant, String name) {}
}
