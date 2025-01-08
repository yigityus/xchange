package com.payd.xchange.repository;

import com.payd.xchange.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByDateTimeGreaterThanEqual(Pageable pageable, OffsetDateTime timestamp);
}
