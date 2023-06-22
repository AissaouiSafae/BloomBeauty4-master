package ma.ehei.BloomBeauty.services;


import ma.ehei.BloomBeauty.entity.varianteCommande;

import java.util.List;

public interface varianteCommandeServices {

    varianteCommande create (varianteCommande varianteCommande);
    List<varianteCommande > read();
    varianteCommande  update (Long id, varianteCommande  varianteCommande);
    String delete(Long id);

}
