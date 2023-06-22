package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.Retour;
import ma.ehei.BloomBeauty.entity.RoleRoute;

import java.util.List;

public interface RoleRouteServices {
    RoleRoute create (RoleRoute roleRoute);
    List<RoleRoute > read();
    RoleRoute  update (Long id, RoleRoute  roleRoute);
    String delete(Long id);
}
