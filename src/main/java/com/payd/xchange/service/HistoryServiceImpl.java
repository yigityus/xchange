package com.payd.xchange.service;

import com.payd.xchange.model.ExchangeDto;
import com.payd.xchange.model.HistoryFilterDto;
import com.payd.xchange.model.Transaction;
import com.payd.xchange.model.mapper.TransactionMapper;
import com.payd.xchange.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Page<ExchangeDto> findByFilter(Pageable pageable, HistoryFilterDto historyFilterDto) {

        if (Objects.isNull(historyFilterDto.getDate()) && Objects.isNull(historyFilterDto.getTransactionId())) {
            throw new IllegalArgumentException("At least either one of date or transactionId must be provided!");
        }

        if (Objects.nonNull(historyFilterDto.getTransactionId())) {
            Optional<Transaction> transaction = transactionRepository
                    .findByTransactionId(historyFilterDto.getTransactionId());
            if (transaction.isPresent()) {
                return new PageImpl<>(Collections.singletonList(
                        transactionMapper.toDto(transaction.get())));
            }
        }

        if (Objects.nonNull(historyFilterDto.getDate())) {
            return transactionRepository
                    .findByCreatedGreaterThan(pageable, historyFilterDto.getDate())
                    .map(transactionMapper::toDto);
        }

        return Page.empty();
    }
}
