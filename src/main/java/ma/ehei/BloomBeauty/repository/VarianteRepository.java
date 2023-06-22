package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.Variante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VarianteRepository extends JpaRepository<Variante, Long> {
}
