package com.payd.xchange.controller;

import com.payd.xchange.model.ExchangeConvert;
import com.payd.xchange.service.HistoryServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryController {

    private final HistoryServiceImpl historyService;

    public HistoryController(HistoryServiceImpl historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/all")
    public List<ExchangeConvert> findAll() {
        return historyService.findAll();
    }

    @PostMapping("/filter")
    public Page<ExchangeConvert> findByFilter(Pageable pageable) {
        return historyService.findByFilter(pageable);
    }
}
