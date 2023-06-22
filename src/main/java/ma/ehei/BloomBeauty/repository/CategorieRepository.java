package ma.ehei.BloomBeauty.repository;



import ma.ehei.BloomBeauty.entity.AdressLivrason;
import ma.ehei.BloomBeauty.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
        List<Categorie> findByParent(Long parentId);
        @Query("SELECT c FROM Categorie c WHERE c.nameFr LIKE %:keyword%")
        List<Categorie> findByKeyword(@Param("keyword") String keyword);



}
