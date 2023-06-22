package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.Etat;

import java.util.List;

public interface EtatService {
    List<Etat> getAllEtats();
    Etat getEtatById(Long id);
    Etat saveOrUpdateEtat(Etat etat);
    void deleteEtat(Long id);
}
