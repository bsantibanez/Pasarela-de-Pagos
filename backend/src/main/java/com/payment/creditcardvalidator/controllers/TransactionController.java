package com.payment.creditcardvalidator.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.payment.creditcardvalidator.entities.Transaction;
import com.payment.creditcardvalidator.services.TransactionService;

import java.util.List;


@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
