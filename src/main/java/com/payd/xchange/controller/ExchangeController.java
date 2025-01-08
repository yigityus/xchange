package com.payd.xchange.controller;

import com.payd.xchange.model.ExchangeDto;
import com.payd.xchange.service.ExchangeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeServiceImpl exchangeService;

    @PostMapping("/exchange")
    public ExchangeDto exchange(@RequestBody @Validated ExchangeDto exchangeDto) {
        return exchangeService.exchange(exchangeDto);
    }

    @PostMapping("/convert")
    public ExchangeDto convert(@RequestBody ExchangeDto exchangeDto) {
        return exchangeService.convert(exchangeDto);
    }
}
