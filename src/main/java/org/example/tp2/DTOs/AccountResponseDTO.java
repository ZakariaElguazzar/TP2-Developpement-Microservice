package org.example.tp2.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp2.Entities.Customer;
import org.example.tp2.Enums.accountType;
import org.example.tp2.Enums.currencyType;

import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AccountResponseDTO {
    private String id;
    private currencyType currency;
    private accountType accountType;
    private Double balance;
    private Date createdAt;
    private Customer customer;
}
