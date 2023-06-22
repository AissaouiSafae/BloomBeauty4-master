package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.varianteCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface varianteCommandeRepository  extends JpaRepository<varianteCommande, Long> {
}
