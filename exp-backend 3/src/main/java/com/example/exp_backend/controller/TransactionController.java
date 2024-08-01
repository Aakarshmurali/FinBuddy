package com.example.exp_backend.controller;

import com.example.exp_backend.dto.TransactionDto;
import com.example.exp_backend.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// Ensure the correct import statement in your controller
import com.example.exp_backend.dto.TotalExpenseResponse;
import com.example.exp_backend.dto.TotalBalanceResponse;
import com.example.exp_backend.dto.TotalIncomeResponse;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/transaction")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionDto> addTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto savedTransaction = transactionService.addTransaction(transactionDto);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getAllTransaction() {
        List<TransactionDto> transactions = transactionService.getAllTransaction();
        return ResponseEntity.ok(transactions);
    }

    @PutMapping("{id}")
    public ResponseEntity<TransactionDto> updateTransaction(@PathVariable("id") Long transactionId,
                                                            @RequestBody TransactionDto updatedTransaction) {
        TransactionDto transactionDto = transactionService.updateTransaction(transactionId, updatedTransaction);
        return ResponseEntity.ok(transactionDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long transactionId) {
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok("Transaction deleted successfully");
    }



    @GetMapping("/total-expense")
    public ResponseEntity<TotalExpenseResponse> getTotalExpense() {
        Double totalExpense = transactionService.getTotalExpense();
        TotalExpenseResponse response = new TotalExpenseResponse(totalExpense);
        return ResponseEntity.ok(response);
    }



    @GetMapping("/total-income")
    public ResponseEntity<TotalIncomeResponse> getTotalIncome() {
        Double totalIncome = transactionService.getTotalIncome();
        TotalIncomeResponse response = new TotalIncomeResponse(totalIncome);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/total-balance")
    public ResponseEntity<TotalBalanceResponse> getTotalBalance() {
        Double totalBalance = transactionService.getTotalBalance();
        TotalBalanceResponse response = new TotalBalanceResponse(totalBalance);
        return ResponseEntity.ok(response);
    }
    

    
}
