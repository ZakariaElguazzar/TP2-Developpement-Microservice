package org.example.tp2.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.tp2.DTOs.AccountRequestDTO;
import org.example.tp2.DTOs.AccountResponseDTO;
import org.example.tp2.Entities.Account;
import org.example.tp2.Mappers.AccountMapper;
import org.example.tp2.Repositories.accountRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class accountServiceImpl implements accountService {
    private accountRepo accountRepo;
    private AccountMapper accountMapper;
    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO accountReq) {
        Account account =  new Account();
        account.setAccountType(accountReq.getAccountType());
        account.setBalance(accountReq.getBalance());
        account.setCurrency(accountReq.getCurrency());
        account.setCreatedAt(new Date());
        Account savedAccount = accountRepo.save(account);
        return accountMapper.fromAccountToAccountResponseDTO(savedAccount);
    }

    @Override
    public Account createAccount(Account account) {
        account.setCreatedAt(new Date());
        return accountRepo.save(account);
    }

    @Override
    public Boolean deleteAccount(String id) {
        try {
            accountRepo.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public AccountResponseDTO searchAccountById(String id) {
        return accountMapper.fromAccountToAccountResponseDTO(accountRepo.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found",id))));
    }

    @Override
    public List<AccountResponseDTO> allAccounts() {
        List<Account> accounts = accountRepo.findAll();
        if (accounts.isEmpty()) {
            throw new RuntimeException("No accounts found");
        }
        return accounts.stream()
                .map(accountMapper::fromAccountToAccountResponseDTO)
                .toList();
    }

    @Override
    public AccountResponseDTO updateAccount(String id,AccountRequestDTO accountReq) {
        AccountResponseDTO existingAccount = searchAccountById(id);
        if (accountReq.getBalance() != null) existingAccount.setBalance(accountReq.getBalance());
        if (accountReq.getCurrency() != null) existingAccount.setCurrency(accountReq.getCurrency());
        if (accountReq.getAccountType() != null) existingAccount.setAccountType(accountReq.getAccountType());
        Account savedAccount = accountMapper.fromAccountResponseDTOToAccount(existingAccount);
        savedAccount.setId(id);
        return accountMapper.fromAccountToAccountResponseDTO(accountRepo.save(savedAccount));
    }

    @Override
    public Account updateAccount(String id,Account account) {
        AccountResponseDTO existingAccount = searchAccountById(id);
        System.out.println("DATE2:"+existingAccount.getCreatedAt());
        Account Account = accountMapper.fromAccountResponseDTOToAccount(existingAccount);
        if (account.getBalance() != null) Account.setBalance(account.getBalance());
        if (account.getCurrency() != null) Account.setCurrency(account.getCurrency());
        if (account.getAccountType() != null) Account.setAccountType(account.getAccountType());
        Account.setId(id);
        System.out.println("DATE2:"+existingAccount.getCreatedAt());
        Account.setCreatedAt(existingAccount.getCreatedAt());
        return accountRepo.save(Account);
    }
}
