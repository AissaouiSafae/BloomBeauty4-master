package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByTel(String tel);
}
