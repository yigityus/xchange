package com.payd.xchange.service;

import com.payd.xchange.model.ExchangeDto;
import com.payd.xchange.model.mapper.TransactionMapper;
import com.payd.xchange.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public ExchangeDto save(ExchangeDto dto) {
        dto.setTransactionId(UUID.randomUUID().toString());
        return transactionMapper.toDto(
                transactionRepository.save(transactionMapper.toEntity(dto)));
    }
}
