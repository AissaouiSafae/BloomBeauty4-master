package ma.ehei.BloomBeauty.repository;

;
import ma.ehei.BloomBeauty.entity.OffresVariante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffresVarianteRepository extends JpaRepository<OffresVariante, Long> {

    
}
