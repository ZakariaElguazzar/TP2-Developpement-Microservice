package org.example.tp2.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.tp2.Entities.Account;
import org.example.tp2.Repositories.accountRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class accountServiceImpl implements accountService {
    private accountRepo accountRepo;
    @Override
    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountRepo.delete(account);
    }

    @Override
    public Account searchAccountById(String id) {
        return accountRepo.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found",id)));
    }

    @Override
    public List<Account> allAccounts() {
        List<Account> accounts = accountRepo.findAll();
        if (accounts.isEmpty()) {
            throw new RuntimeException("No accounts found");
        }
        return accounts;
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepo.save(account);
    }
}
