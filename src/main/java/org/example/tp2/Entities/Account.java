package org.example.tp2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp2.Enums.accountType;

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
    private double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private accountType accountType;


}
