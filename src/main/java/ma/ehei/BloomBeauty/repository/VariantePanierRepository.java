package ma.ehei.BloomBeauty.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ehei.BloomBeauty.entity.VariantePanier;

@Repository
public interface VariantePanierRepository extends JpaRepository<VariantePanier, Long> {

}