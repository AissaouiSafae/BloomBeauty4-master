package ma.ehei.BloomBeauty.services;



import ma.ehei.BloomBeauty.entity.Roles;

import java.util.List;

public interface RolesServices {
    Roles create (Roles roles);
    List<Roles > read();
    Roles  update (Long id, Roles  roles);
    String delete(Long id);
}
