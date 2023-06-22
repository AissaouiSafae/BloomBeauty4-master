package ma.ehei.BloomBeauty.services;



import ma.ehei.BloomBeauty.entity.Inventaire;
import ma.ehei.BloomBeauty.entity.Produit;
import ma.ehei.BloomBeauty.entity.Variante;

import java.util.List;

public interface InventaireServices {

    Inventaire create (Inventaire inventaire);
    List<Inventaire> read();
    Inventaire update (Long id, Inventaire  inventaire);
    String delete(Long id);



}
