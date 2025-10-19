package org.example.tp2.Repositories;

import org.example.tp2.Entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepo extends JpaRepository<Compte,String> {

}
