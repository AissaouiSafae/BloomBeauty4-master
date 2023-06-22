package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Fournisseur;
import ma.ehei.BloomBeauty.entity.Ville;
import ma.ehei.BloomBeauty.repository.VilleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VillesServicesImpelments implements VilleServices{
    public  final VilleRepository villeRepository;
    @Override
    public Ville create(Ville ville) {
        return villeRepository.save(ville);
    }

    public Ville getVilleById(Long id) {
        Optional<Ville> optionalVille = villeRepository.findById(id);
        if (optionalVille.isPresent()) {
            return optionalVille.get();
        } else {
            throw new RuntimeException("ville introuvable avec l'identifiant : " + id);
        }
    }

    @Override
    public List<Ville> read() {
        return villeRepository.findAll();
    }

    @Override
    public Ville update(Long id, Ville ville) {
        return villeRepository.findById(id)
                .map(ctl->{
                    ctl.setNameFr(ville.getNameFr());
                    villeRepository.save(ctl);
                    return ville;
                }).orElseThrow(() -> new RuntimeException("ville introuvable"));
    }


    @Override
    public String delete(Long id) {
        villeRepository.deleteById(id);
        return "Bien Supprimer";
    }

    @Override
    public Ville findById(Long id) {
        return villeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ville introuvable"));
    }

    @Override
    public List<Fournisseur> getFournisseursByVille(Long villeId) {
        Ville ville = villeRepository.findById(villeId)
                .orElseThrow(() -> new RuntimeException("ville introuvable"));
        return ville.getFournisseurs();
    }

    @Override
    public List<Ville> findByKeyword(String keyword) {
        return villeRepository.findByKeyword(keyword);
    }

}
