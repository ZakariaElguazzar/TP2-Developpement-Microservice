package org.example.tp2.Services;

import org.example.tp2.Entities.Account;

import java.util.List;


public interface accountService {
    Account createAccount(Account account);
    void deleteAccount(Account account);
    Account searchAccountById(String id);
    List<Account> allAccounts();
    Account updateAccount(Account account);


}
