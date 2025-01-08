package com.payd.xchange.model.mapper;

import com.payd.xchange.model.ExchangeConvert;
import com.payd.xchange.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "trxId", target = "transactionId")
    Transaction toEntity(ExchangeConvert record);
    @Mapping(target = "trxId", source = "transactionId")
    ExchangeConvert toDto(Transaction entity);
    List<ExchangeConvert> toDto(List<Transaction> entity);
}
