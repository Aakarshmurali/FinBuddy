package com.example.exp_backend.mapper;

import com.example.exp_backend.dto.TransactionDto;
import com.example.exp_backend.entity.Transaction;

public class TransactionMapper {
    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getTransactionId(),
                transaction.getTransactionType(),
                transaction.getTransactionDescription(),
                transaction.getTransactionAmount(),
                transaction.getTransactionDate()

        );
    }

    public static Transaction mapToTransaction(TransactionDto transactionDto) {
        return new Transaction(
                transactionDto.getTransactionId(),
                transactionDto.getTransactionType(),
                transactionDto.getTransactionDescription(),
                transactionDto.getTransactionAmount(),
                transactionDto.getTransactionDate()

        );
    }

}
