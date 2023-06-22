package ma.ehei.BloomBeauty.repository;

import ma.ehei.BloomBeauty.entity.AdressLivrason;
import ma.ehei.BloomBeauty.entity.Attribut;
import ma.ehei.BloomBeauty.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributRepository extends JpaRepository<Attribut, Long> {
    @Query("SELECT a FROM Attribut a WHERE a.NameFr LIKE %:keyword%")
    List<Attribut> findByKeyword(@Param("keyword") String keyword);

}
