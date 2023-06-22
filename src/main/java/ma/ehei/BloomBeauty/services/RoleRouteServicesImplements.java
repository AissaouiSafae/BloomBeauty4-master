package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.RoleRoute;
import ma.ehei.BloomBeauty.repository.RoleRouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RoleRouteServicesImplements implements RoleRouteServices{
    public final RoleRouteRepository roleRouteRepository;
    @Override
    public RoleRoute create(RoleRoute roleRoute) {
        return roleRouteRepository.save(roleRoute);
    }

    @Override
    public List<RoleRoute> read() {
        return roleRouteRepository.findAll();
    }

    @Override
    public RoleRoute update(Long id, RoleRoute roleRoute) {
        RoleRoute updatedRoleRoute = roleRouteRepository.findById(id)
                .map(rr -> {
                    rr.setRoles(roleRoute.getRoles());
                    rr.setRoutes(roleRoute.getRoutes());
                    return roleRouteRepository.save(rr);
                })
                .orElseThrow(() -> new RuntimeException("RoleRoute introuvable"));
        return updatedRoleRoute;
    }

    @Override
    public String delete(Long id) {
        return "Bien supprimer";
    }
}
