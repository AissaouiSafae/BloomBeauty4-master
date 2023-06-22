package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Fournisseur;
import ma.ehei.BloomBeauty.repository.FournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class FournisseurServicesImplements implements FournisseurServices {
    public final FournisseurRepository fournisseurRepository;
    @Override
    public Fournisseur create(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }
    @Override
    public Fournisseur getFournisseurById(Long id) {
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(id);
        if (optionalFournisseur.isPresent()) {
            return optionalFournisseur.get();
        } else {
            throw new RuntimeException("Fournisseur introuvable avec l'identifiant : " + id);
        }
    }
    @Override
    public List<Fournisseur> read() {
        return fournisseurRepository.findAll();
    }
    @Override
    public Fournisseur update(Fournisseur fournisseur) {
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(fournisseur.getId());
        if (optionalFournisseur.isPresent()) {
            Fournisseur existingFournisseur = optionalFournisseur.get();
            existingFournisseur.setNameFr(fournisseur.getNameFr());
            existingFournisseur.setBanque(fournisseur.getBanque());
            existingFournisseur.setRib(fournisseur.getRib());
            existingFournisseur.setVille(fournisseur.getVille());
            Fournisseur updatedFournisseur = fournisseurRepository.saveAndFlush(existingFournisseur);
            return updatedFournisseur;
        } else {
            throw new RuntimeException("Fournisseur introuvable avec l'identifiant : " + fournisseur.getId());
        }
    }

    @Override
    public String delete(Long id) {
        fournisseurRepository.deleteById(id);
        return "bien supprimer";
    }
    @Override
    public List<Fournisseur> findByKeyword(String keyword) {
        return fournisseurRepository.findByKeyword("%" + keyword + "%");
    }



}
