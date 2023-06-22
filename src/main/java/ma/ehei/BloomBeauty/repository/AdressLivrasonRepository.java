package ma.ehei.BloomBeauty.repository;

import ma.ehei.BloomBeauty.entity.AdressLivrason;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdressLivrasonRepository   extends JpaRepository< AdressLivrason, Long>
{

}
