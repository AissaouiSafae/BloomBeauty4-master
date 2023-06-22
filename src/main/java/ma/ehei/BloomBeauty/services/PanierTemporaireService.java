package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.PanierTemporaire;

import java.util.List;

public interface PanierTemporaireService {
    List<PanierTemporaire> getAllPanierTemporaires();
    PanierTemporaire getPanierTemporaireById(Long id);
    PanierTemporaire savePanierTemporaire(PanierTemporaire panierTemporaire);
    void deletePanierTemporaire(Long id);
}
