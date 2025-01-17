package com.payd.xchange.service;

import com.payd.xchange.model.ExchangeDto;
import com.payd.xchange.model.HistoryFilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HistoryService {
    List<ExchangeDto> findAll();
    Page<ExchangeDto> findByFilter(Pageable pageable, HistoryFilterDto historyFilterDto);
}
