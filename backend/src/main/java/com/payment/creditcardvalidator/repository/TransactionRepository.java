package com.payment.creditcardvalidator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.creditcardvalidator.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}