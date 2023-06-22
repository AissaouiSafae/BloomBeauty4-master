package ma.ehei.BloomBeauty.repository;

import ma.ehei.BloomBeauty.entity.EtatCmd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatCmdRepository extends JpaRepository<EtatCmd, Long> {
}
