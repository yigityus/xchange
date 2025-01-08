package com.payd.xchange.controller;

import com.payd.xchange.model.ExchangeConvert;
import com.payd.xchange.model.ExchangeRate;
import com.payd.xchange.service.ExchangeServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    private final ExchangeServiceImpl exchangeService;

    public ExchangeController(ExchangeServiceImpl exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping("/exchange")
    public ExchangeRate exchange(@RequestBody ExchangeRate exchangeRate) {
        return exchangeService.exchange(exchangeRate);
    }

    @PostMapping("/convert")
    public ExchangeConvert convert(@RequestBody ExchangeConvert exchangeConvert) {
        return exchangeService.convert(exchangeConvert);
    }
}
