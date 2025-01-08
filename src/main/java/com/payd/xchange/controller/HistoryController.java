package com.payd.xchange.controller;

import com.payd.xchange.model.ExchangeDto;
import com.payd.xchange.service.HistoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryServiceImpl historyService;

    @GetMapping("/all")
    public List<ExchangeDto> findAll() {
        return historyService.findAll();
    }

    @PostMapping("/filter")
    public Page<ExchangeDto> findByFilter(Pageable pageable) {
        return historyService.findByFilter(pageable);
    }
}