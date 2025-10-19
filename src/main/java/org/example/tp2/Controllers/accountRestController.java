package org.example.tp2.Controllers;

import lombok.AllArgsConstructor;
import org.example.tp2.Entities.Account;
import org.example.tp2.Services.accountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class accountRestController {
    private accountService accountService;
    @PostMapping(value = "/save",consumes = {"application/json","application/xml"},produces = {"application/xml","application/json"})
    public Account save(@RequestBody Account account){
        return accountService.createAccount(account);
    }
    @GetMapping("/get/all")
    public List<Account> getAccounts(){
        return accountService.allAccounts();
    }
    @GetMapping("/get/{id}")
    public Account getAccount(@PathVariable(name = "id",required = true) String id){
        return accountService.searchAccountById(id);
    }
    @PutMapping(value = "/update/{id}",consumes = {"application/json","application/xml"},produces = {"application/xml","application/json"})
    public Account update(@PathVariable(value = "id")String id,@RequestBody Account account) {
        Account existingAccount=accountService.searchAccountById(id);
        if (account.getBalance() != null) existingAccount.setBalance(account.getBalance());
        if (account.getCurrency() != null) existingAccount.setCurrency(account.getCurrency());
        if (account.getAccountType() != null) existingAccount.setAccountType(account.getAccountType());
        return accountService.updateAccount(existingAccount);
    }
    @DeleteMapping(value = "/delete/{id}" )
    public void delete(@PathVariable(name = "id",required = true) String id){
        Account account=accountService.searchAccountById(id);
        accountService.deleteAccount(account);
    }
}
