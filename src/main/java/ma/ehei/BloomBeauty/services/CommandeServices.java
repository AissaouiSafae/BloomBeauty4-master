package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.AdressLivrason;
import ma.ehei.BloomBeauty.entity.Commande;

import java.util.List;

public interface CommandeServices {

    Commande saveCommande(Commande commande);

    Commande updateCommande(Commande commande);

    void deleteCommandeById(Long id);

    Commande getCommandeById(Long id);

    List<Commande> getAllCommandes();
}
