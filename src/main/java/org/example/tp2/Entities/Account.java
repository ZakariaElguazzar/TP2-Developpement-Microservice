package org.example.tp2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp2.Enums.accountType;
import org.example.tp2.Enums.currencyType;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date creationAt;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private currencyType currency;
    @Enumerated(EnumType.STRING)
    private accountType accountType;


}
