package ma.ehei.BloomBeauty.repository;

import ma.ehei.BloomBeauty.entity.VarianteAchetee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteAcheteeRepository  extends JpaRepository<VarianteAchetee, Long> {
}
