package com.example.exp_backend.service;

import com.example.exp_backend.dto.TransactionDto;
import com.example.exp_backend.entity.Transaction;

import java.util.List;

public interface TransactionService {
    TransactionDto addTransaction(TransactionDto transactionDto);

    TransactionDto getTransactionById(Long transactionId);

    List<TransactionDto> getAllTransaction();

    TransactionDto updateTransaction(Long transactionId, TransactionDto updatedTransaction);

    void deleteTransaction(Long transactionId);

    Double getTotalIncome();

    Double getTotalExpense();

    Double getTotalBalance();


}

