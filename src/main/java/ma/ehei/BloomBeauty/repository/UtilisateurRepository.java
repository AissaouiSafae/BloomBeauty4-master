package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByLoginAndPassWord(String login, String passWord);
}
