package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Etat;
import ma.ehei.BloomBeauty.repository.EtatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EtatServiceImpl  implements EtatService {


    private final   EtatRepository etatRepository;

    @Override
    public List<Etat> getAllEtats() {
        return etatRepository.findAll();
    }

    @Override
    public Etat getEtatById(Long id) {
        return etatRepository.findById(id).orElse(null);
    }

    @Override
    public Etat saveOrUpdateEtat(Etat etat) {
        return etatRepository.save(etat);
    }

    @Override
    public void deleteEtat(Long id) {
        etatRepository.deleteById(id);
    }
}