package org.example.tp2.Services;

import org.example.tp2.DTOs.AccountRequestDTO;
import org.example.tp2.DTOs.AccountResponseDTO;
import org.example.tp2.Entities.Account;

import java.util.List;


public interface accountService {
    AccountResponseDTO createAccount(AccountRequestDTO account);
    Boolean deleteAccount(String id);
    AccountResponseDTO searchAccountById(String id);
    List<AccountResponseDTO> allAccounts();
    AccountResponseDTO updateAccount(String id,AccountRequestDTO account);
    Account createAccount(Account account);
    Account updateAccount(String id,Account account);


}
