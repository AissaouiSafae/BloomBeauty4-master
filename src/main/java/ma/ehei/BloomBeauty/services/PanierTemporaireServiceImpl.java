package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.PanierTemporaire;
import ma.ehei.BloomBeauty.repository.PanierTemporaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PanierTemporaireServiceImpl implements PanierTemporaireService {
    private final PanierTemporaireRepository panierTemporaireRepository;



    @Override
    public List<PanierTemporaire> getAllPanierTemporaires() {
        return panierTemporaireRepository.findAll();
    }

    @Override
    public PanierTemporaire getPanierTemporaireById(Long id) {
        return panierTemporaireRepository.findById(id).orElse(null);
    }

    @Override
    public PanierTemporaire savePanierTemporaire(PanierTemporaire panierTemporaire) {
        return panierTemporaireRepository.save(panierTemporaire);
    }

    @Override
    public void deletePanierTemporaire(Long id) {
        panierTemporaireRepository.deleteById(id);
    }
}
