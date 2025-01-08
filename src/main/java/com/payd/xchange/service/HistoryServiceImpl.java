package com.payd.xchange.service;

import com.payd.xchange.model.ExchangeDto;
import com.payd.xchange.model.Transaction;
import com.payd.xchange.model.mapper.TransactionMapper;
import com.payd.xchange.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public List<ExchangeDto> findAll() {
        return transactionMapper.toDto(transactionRepository.findAll());
    }

    @Override
    public Page<ExchangeDto> findByFilter(Pageable pageable) {
        Page<Transaction> page = transactionRepository
                .findByDateTimeGreaterThanEqual(pageable, OffsetDateTime.now().minusDays(10));
        return Page.empty();
    }
}
