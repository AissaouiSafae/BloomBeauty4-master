package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.PanierTemporaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierTemporaireRepository  extends JpaRepository<PanierTemporaire, Long> {


}
