package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {


}
