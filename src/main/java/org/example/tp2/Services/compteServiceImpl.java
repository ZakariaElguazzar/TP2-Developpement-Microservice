package org.example.tp2.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.tp2.Entities.Compte;
import org.example.tp2.Repositories.CompteRepo;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Transactional
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
