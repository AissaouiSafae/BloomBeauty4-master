package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.AdressLivrason;
import ma.ehei.BloomBeauty.entity.Commande;
import ma.ehei.BloomBeauty.entity.Commentaire;

import java.util.List;

public interface CommentaireServices {
    Commentaire create (Commentaire commentaire);
    List<Commentaire> read();
    Commentaire update (Long id, Commentaire  commentaire);
    String delete(Long id);
}
