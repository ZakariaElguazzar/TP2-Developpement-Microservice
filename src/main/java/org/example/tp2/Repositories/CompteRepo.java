package org.example.tp2.Repositories;

import org.example.tp2.Entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepo extends JpaRepository<Compte,String> {
    Optional<Compte> findById(String id);
    void deleteById(String id);
    Compte save(Compte compte);

}
