package com.payd.xchange.model.mapper;

import com.payd.xchange.model.ExchangeDto;
import com.payd.xchange.model.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction toEntity(ExchangeDto dto);
    ExchangeDto toDto(Transaction entity);
    List<ExchangeDto> toDto(List<Transaction> entity);
}
