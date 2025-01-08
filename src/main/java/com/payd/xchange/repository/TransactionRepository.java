package com.payd.xchange.repository;

import com.payd.xchange.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByCreatedGreaterThan(Pageable pageable, LocalDateTime timestamp);
    Optional<Transaction> findByTransactionId(String transactionId);
}
