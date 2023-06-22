package ma.ehei.BloomBeauty.repository;


import ma.ehei.BloomBeauty.entity.RoleRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRouteRepository extends JpaRepository<RoleRoute, Long> {
}
