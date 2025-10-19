package org.example.tp2.Services;

import org.example.tp2.Entities.Compte;
import org.springframework.stereotype.Service;

@Service
public interface compteService {
    Compte createCompte(Compte compte);
    void deleteCompte(Compte compte);
    Compte SearchCompteById(String id);


}
