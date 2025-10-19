package org.example.tp2.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp2.Enums.accountType;
import org.example.tp2.Enums.currencyType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequestDTO {
    private currencyType currency;
    private accountType accountType;
    private Double balance;
}
