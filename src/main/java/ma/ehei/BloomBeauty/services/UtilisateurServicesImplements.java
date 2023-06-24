package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Utilisateur;
import ma.ehei.BloomBeauty.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor


public class UtilisateurServicesImplements implements UtilisateurServices{

   public final UtilisateurRepository utilisateurRepository;
    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur) ;
    }

    @Override
    public List<Utilisateur> read() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur update(Long id, Utilisateur utilisateur) {

        return utilisateurRepository.findById(id)
                .map(ctl->{
                    ctl.setNomComplet(utilisateur.getNomComplet());
                    ctl.setTel(utilisateur.getTel());
                    ctl.setAdressPostal(utilisateur.getAdressPostal());
                    ctl.setEmail(utilisateur.getEmail());
                    ctl.setPassWord(utilisateur.getPassWord());
                    ctl.setLogin(utilisateur.getLogin());
                    utilisateurRepository.save(ctl);
                    return utilisateur;


                }).orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
    }

    @Override
    public String delete(Long id) {
        utilisateurRepository.deleteById(id);
        return "Bien Supprimer";
    }

    @Override
    public Utilisateur findByLoginAndPassword(String login, String password) {
        return utilisateurRepository.findByLoginAndPassWord(login, password);
    }
}

