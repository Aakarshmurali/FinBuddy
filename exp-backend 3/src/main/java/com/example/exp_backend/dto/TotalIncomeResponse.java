package com.example.exp_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TotalIncomeResponse {
    private Double totalIncome;

    public TotalIncomeResponse(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

}
