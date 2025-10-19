package org.example.tp2.Repositories;

import org.example.tp2.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface accountRepo extends JpaRepository<Account,String> {

}
