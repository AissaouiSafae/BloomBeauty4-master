package ma.ehei.BloomBeauty.repository;

import ma.ehei.BloomBeauty.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("SELECT p FROM Produit p WHERE p.nameFr LIKE %:keyword% OR p.categorie.nameFr LIKE %:keyword% OR p.attribut.NameFr LIKE %:keyword%")
    List<Produit> searchByKeyword(@Param("keyword") String keyword);
    @Query("SELECT p FROM Produit p JOIN FETCH p.categorie JOIN FETCH p.attribut")
    List<Produit> findAllWithCategoriesAndAttributes();
}
