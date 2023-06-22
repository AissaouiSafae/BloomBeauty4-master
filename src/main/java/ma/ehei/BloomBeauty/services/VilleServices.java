package ma.ehei.BloomBeauty.services;


import ma.ehei.BloomBeauty.entity.Fournisseur;
import ma.ehei.BloomBeauty.entity.Ville;

import java.util.List;

public interface VilleServices {
    Ville create (Ville ville);
    List<Ville > read();
    Ville  update (Long id, Ville  ville);
    List<Fournisseur> getFournisseursByVille(Long villeId);
    public List<Ville> findByKeyword(String keyword);
    String delete(Long id);

    Ville findById(Long id);
}
