package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.VarianteRetour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteRetourRepository  extends JpaRepository<VarianteRetour, Long> {
}
