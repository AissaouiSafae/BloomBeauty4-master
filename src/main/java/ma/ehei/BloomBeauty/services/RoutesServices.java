package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.Routes;

import java.util.List;

public interface RoutesServices {
    Routes create(Routes route);
    List<Routes> read();
    Routes update(Long id, Routes route);
    String delete(Long id);
}
