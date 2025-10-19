package org.example.tp2.Services;

import lombok.AllArgsConstructor;
import org.example.tp2.Entities.Compte;
import org.example.tp2.Repositories.CompteRepo;

@AllArgsConstructor
public class compteServiceImpl implements compteService {
    private CompteRepo compteRepo;
    @Override
    public Compte createCompte(Compte compte) {
        return compteRepo.save(compte);
    }

    @Override
    public void deleteCompte(Compte compte) {
        compteRepo.delete(compte);
    }

    @Override
    public Compte SearchCompteById(String id) {
        return compteRepo.findById(id).orElse(null);
    }
}
