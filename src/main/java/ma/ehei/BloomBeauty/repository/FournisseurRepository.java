package ma.ehei.BloomBeauty.repository;

import ma.ehei.BloomBeauty.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurRepository  extends JpaRepository<Fournisseur, Long> {

    @Query("SELECT f FROM Fournisseur f WHERE f.NameFr LIKE :keyword OR f.banque LIKE :keyword OR f.banque LIKE :keyword Or f.ville.nameFr LIKE :keyword ")
    List<Fournisseur> findByKeyword(@Param("keyword") String keyword);

}
