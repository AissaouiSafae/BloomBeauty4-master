package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.AdressLivrason;
import ma.ehei.BloomBeauty.entity.Attribut;
import ma.ehei.BloomBeauty.entity.Produit;

import java.util.List;

public interface AttributServices {
    Attribut create (Attribut attribut);
    List<Attribut> read();
    Attribut update (Long id,Attribut attribut);
    String delete(Long id);

    List<Produit> getProduitsByAttribut(Long id);
    Attribut getAttributById(Long attributId);
    List<Attribut> findByKeyword(String keyword);
}
