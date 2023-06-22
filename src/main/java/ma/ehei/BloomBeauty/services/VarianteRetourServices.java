package ma.ehei.BloomBeauty.services;



import ma.ehei.BloomBeauty.entity.VarianteRetour;

import java.util.List;

public interface VarianteRetourServices {
    VarianteRetour save(VarianteRetour varianteRetour);
    void deleteById(Long id);
    VarianteRetour findById(Long id);
    List<VarianteRetour> findAll();
}
