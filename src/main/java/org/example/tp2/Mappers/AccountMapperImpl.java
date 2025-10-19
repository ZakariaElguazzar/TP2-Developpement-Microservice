package org.example.tp2.Mappers;


import org.example.tp2.DTOs.AccountResponseDTO;
import org.example.tp2.Entities.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountResponseDTO fromAccountToAccountResponseDTO(Account account) {
        AccountResponseDTO accountResp = new AccountResponseDTO();
        BeanUtils.copyProperties(account, accountResp);
        return accountResp;
    }

    @Override
    public Account fromAccountResponseDTOToAccount(AccountResponseDTO accountResp) {
        Account account = new Account();
        BeanUtils.copyProperties(accountResp, account);
        return account;
    }
}
