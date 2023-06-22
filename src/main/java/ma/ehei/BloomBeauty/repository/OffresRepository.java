package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.Offres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OffresRepository extends JpaRepository<Offres, Long> {
}
