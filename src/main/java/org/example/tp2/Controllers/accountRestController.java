package org.example.tp2.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.tp2.DTOs.AccountRequestDTO;
import org.example.tp2.DTOs.AccountResponseDTO;
import org.example.tp2.Services.accountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
@Tag(name = "Accounts", description = "Operations on Accounts")
public class accountRestController {
    private accountService accountService;
    @PostMapping(value = "/save",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
    @Operation(summary = "Create a new account", description = "Saves a new account to the database")
    public AccountResponseDTO createAccount(@RequestBody AccountRequestDTO account){
        return accountService.createAccount(account);
    }
    @GetMapping(value = "/get/all",produces = {"application/json","application/xml"})
    @Operation(summary = "Retrieve all accounts", description = "Returns a list of all accounts")
    public List<AccountResponseDTO> getAccounts(){
        return accountService.allAccounts();
    }
    @GetMapping(value = "/get/{id}",produces = {"application/json","application/xml"})
    @Operation(summary = "Retrieve an account by ID", description = "Returns the account with the specified ID")
    public AccountResponseDTO getAccount(@PathVariable(name = "id",required = true) String id){
        return accountService.searchAccountById(id);
    }
    @PutMapping(value = "/update/{id}", consumes = { "application/json", "application/xml" }, produces = { "application/json", "application/xml" }
    )
    public AccountResponseDTO update(@PathVariable("id") String id,@RequestBody AccountRequestDTO accountReq) {
        return accountService.updateAccount(id,accountReq);
    }

    @DeleteMapping(value = "/delete/{id}" )
    @Operation(summary = "Delete an account", description = "Deletes an account by its unique ID"
    )
    public void delete(@PathVariable(name = "id",required = true) String id){
        accountService.deleteAccount(id);
    }
}
