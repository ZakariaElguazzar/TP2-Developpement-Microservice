package org.example.tp2.Controllers;

import lombok.AllArgsConstructor;
import org.example.tp2.Entities.Account;
import org.example.tp2.Mappers.AccountMapper;
import org.example.tp2.Services.accountService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/graphql/account")
public class accountGraphqlController {
    private accountService accountService;
    private AccountMapper accountMapper;
    @QueryMapping
    public List<Account> getAllAccounts(){
        return accountService.allAccounts().stream()
                .map(accountMapper::fromAccountResponseDTOToAccount)
                .toList();
    }
    @QueryMapping
    public Account accountById(@Argument("id") String id){
        return accountMapper.fromAccountResponseDTOToAccount(accountService.searchAccountById(id));
    }

    @MutationMapping
    public Account createAccount(@Argument("Account") Account account){
        return accountService.createAccount(account);
    }

    @MutationMapping
    public Account Update(@Argument("id") String id,@Argument("Account") Account account){
        return accountService.updateAccount(id,account);
    }

    @MutationMapping
    public Boolean Delete(@Argument("id") String id){
        return accountService.deleteAccount(id);
    }
}