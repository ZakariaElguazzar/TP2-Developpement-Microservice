package org.example.tp2.Services;

import org.example.tp2.DTOs.AccountRequestDTO;
import org.example.tp2.DTOs.AccountResponseDTO;

import java.util.List;


public interface accountService {
    AccountResponseDTO createAccount(AccountRequestDTO account);
    void deleteAccount(String id);
    AccountResponseDTO searchAccountById(String id);
    List<AccountResponseDTO> allAccounts();
    AccountResponseDTO updateAccount(String id,AccountRequestDTO account);


}
