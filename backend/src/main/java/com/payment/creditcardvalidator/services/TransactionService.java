package com.payment.creditcardvalidator.services;

import java.util.List;

import com.payment.creditcardvalidator.entities.Transaction;

public interface TransactionService {

    List<Transaction> getAllTransactions();

}
