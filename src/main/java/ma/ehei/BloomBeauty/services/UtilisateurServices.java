package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.Utilisateur;

import java.util.List;

public interface UtilisateurServices {
    Utilisateur create (Utilisateur utilisateur);
    List<Utilisateur > read ();
    Utilisateur  update (Long id, Utilisateur  utilisateur);
    String delete(Long id);
    Utilisateur findByLoginAndPassword(String login, String password);

}


