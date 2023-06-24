package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.DTO.User;
import ma.ehei.BloomBeauty.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByLoginAndPassWord(String tel, String passWord);
    Optional<User> findByTel(String tel);
}
