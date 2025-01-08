package com.payd.xchange.service;

import com.payd.xchange.model.ExchangeConvert;
import com.payd.xchange.model.Transaction;
import com.payd.xchange.model.mapper.TransactionMapper;
import com.payd.xchange.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public HistoryServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public List<ExchangeConvert> findAll() {
        return transactionMapper.toDto(transactionRepository.findAll());
    }

    @Override
    public Page<ExchangeConvert> findByFilter(Pageable pageable) {
        Page<Transaction> page = transactionRepository
                .findByDateTimeGreaterThanEqual(pageable, OffsetDateTime.now().minusDays(10));
        return Page.empty();
    }
}
