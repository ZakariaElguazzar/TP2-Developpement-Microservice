package org.example.tp2.Mappers;
import org.example.tp2.DTOs.AccountResponseDTO;
import org.example.tp2.Entities.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountMapper {
    AccountResponseDTO fromAccountToAccountResponseDTO(Account account);
    Account fromAccountResponseDTOToAccount(AccountResponseDTO accountResp);

}
