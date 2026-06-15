package com.payment.creditcardvalidator.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payment.creditcardvalidator.entities.Transaction;
import com.payment.creditcardvalidator.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
