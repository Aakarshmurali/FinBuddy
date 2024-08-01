
package com.example.exp_backend.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TotalExpenseResponse {
    private Double totalExpense;

    public TotalExpenseResponse(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

}