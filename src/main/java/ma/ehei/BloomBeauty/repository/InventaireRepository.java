package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.Inventaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventaireRepository  extends JpaRepository<Inventaire, Long> {

}
