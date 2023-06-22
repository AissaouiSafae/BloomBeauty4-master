package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.Variante;

import java.util.List;
import java.util.Optional;

public interface VarianteServices {
    Variante create (Variante variante);
    List<Variante > read();
    Variante  update (Long id, Variante  variante);
    String delete(Long id);


    Optional<Variante> getVarianteById(Long id);
}
