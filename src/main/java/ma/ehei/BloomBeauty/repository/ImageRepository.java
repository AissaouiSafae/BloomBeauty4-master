package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
