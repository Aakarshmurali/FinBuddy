package com.example.exp_backend.service.impl;

import com.example.exp_backend.dto.TransactionDto;
import com.example.exp_backend.entity.Transaction;
import com.example.exp_backend.mapper.TransactionMapper;
import com.example.exp_backend.repository.TransactionRepository;
import com.example.exp_backend.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;

    @Override
    public TransactionDto addTransaction(TransactionDto transactionDto) {
        Transaction transaction = TransactionMapper.mapToTransaction(transactionDto);
        transaction.setTransactionDate(LocalDate.now());
        Transaction savedTransaction = transactionRepository.save(transaction);
        return TransactionMapper.mapToTransactionDto(savedTransaction);
    }

    @Override
    public TransactionDto getTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return TransactionMapper.mapToTransactionDto(transaction);
    }

    @Override
    public List<TransactionDto> getAllTransaction() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(TransactionMapper::mapToTransactionDto)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto updateTransaction(Long transactionId, TransactionDto updatedTransaction) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transaction.setTransactionType(updatedTransaction.getTransactionType());
        transaction.setTransactionDescription(updatedTransaction.getTransactionDescription());
        transaction.setTransactionAmount(updatedTransaction.getTransactionAmount());
        Transaction updatedTransactionObj = transactionRepository.save(transaction);
        return TransactionMapper.mapToTransactionDto(updatedTransactionObj);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transactionRepository.deleteById(transactionId);
    }

    // New methods
    @Override
    public Double getTotalIncome() {
        return transactionRepository.findAll().stream()
                .filter(transaction -> "income".equalsIgnoreCase(transaction.getTransactionType()))
                .mapToDouble(Transaction::getTransactionAmount)
                .sum();
    }

    @Override
    public Double getTotalExpense() {
        return transactionRepository.findAll().stream()
                .filter(transaction -> "expense".equalsIgnoreCase(transaction.getTransactionType()))
                .mapToDouble(Transaction::getTransactionAmount)
                .sum();
    }

    @Override
    public Double getTotalBalance() {
        return getTotalIncome() - getTotalExpense();
    }



}
