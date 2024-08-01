package com.example.exp_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TotalBalanceResponse {
    private Double totalBalance;

    public TotalBalanceResponse(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

}
