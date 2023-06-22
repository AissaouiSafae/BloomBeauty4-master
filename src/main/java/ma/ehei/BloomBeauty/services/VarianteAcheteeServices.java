package ma.ehei.BloomBeauty.services;



import ma.ehei.BloomBeauty.entity.VarianteAchetee;

import java.util.List;

public interface VarianteAcheteeServices {
    VarianteAchetee create (VarianteAchetee varianteAchetee);
    List<VarianteAchetee > read();
    VarianteAchetee  update (Long id, VarianteAchetee  varianteAchetee);
    String delete(Long id);
}
