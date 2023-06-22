package ma.ehei.BloomBeauty.repository;

import ma.ehei.BloomBeauty.entity.FactureAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureAchatRepository extends JpaRepository<FactureAchat, Long> {
}
