package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.DTO.User;
import ma.ehei.BloomBeauty.entity.Utilisateur;
import ma.ehei.BloomBeauty.repository.UserRepository;
import ma.ehei.BloomBeauty.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor


public class UserServicesImplements implements UserServices {
    public final UserRepository utilisateurRepository;
    @Override
    public User create(User utilisateur) {
        return utilisateurRepository.save(utilisateur) ;
    }

    @Override
    public List<User> read() {
        return utilisateurRepository.findAll();
    }

    @Override
    public User update(Long id, User utilisateur) {

        return utilisateurRepository.findById(id)
                .map(ctl->{
                    ctl.setNomComplet(utilisateur.getNomComplet());
                    ctl.setTel(utilisateur.getTel());
                    ctl.setEmail(utilisateur.getEmail());
                    ctl.setPassword(utilisateur.getPassword());
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
    public User findByLoginAndPassword(String login, String password) {
        return utilisateurRepository.findByLoginAndPassWord(login, password);
    }
}
