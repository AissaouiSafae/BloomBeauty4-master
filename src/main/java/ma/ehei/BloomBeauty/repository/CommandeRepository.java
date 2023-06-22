package ma.ehei.BloomBeauty.repository;

import ma.ehei.BloomBeauty.entity.Categorie;
import ma.ehei.BloomBeauty.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
