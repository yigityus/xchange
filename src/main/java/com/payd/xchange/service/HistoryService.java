package com.payd.xchange.service;

import com.payd.xchange.model.ExchangeConvert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HistoryService {
    List<ExchangeConvert> findAll();
    Page<ExchangeConvert> findByFilter(Pageable pageable);
}
