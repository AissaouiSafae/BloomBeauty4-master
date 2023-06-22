package ma.ehei.BloomBeauty.repository;

import ma.ehei.BloomBeauty.entity.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoutesRepository extends JpaRepository<Routes, Long> {
}
