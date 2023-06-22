package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface VilleRepository extends JpaRepository<Ville, Long> {
    @Query("SELECT v FROM Ville v WHERE v.nameFr LIKE %:keyword%")
    List<Ville> findByKeyword(@Param("keyword") String keyword);

}
