package com.payd.xchange.service;

import com.payd.xchange.model.ExchangeConvert;
import com.payd.xchange.model.Transaction;
import com.payd.xchange.model.mapper.TransactionMapper;
import com.payd.xchange.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public ExchangeConvert save(ExchangeConvert record) {
        return transactionMapper.toDto(
                transactionRepository.save(transactionMapper.toEntity(record)));
    }
}
