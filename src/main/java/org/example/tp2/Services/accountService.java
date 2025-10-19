package org.example.tp2.Services;

import org.example.tp2.Entities.Account;


public interface accountService {
    Account createAccount(Account account);
    void deleteAccount(Account account);
    Account searchAccountById(String id);


}
