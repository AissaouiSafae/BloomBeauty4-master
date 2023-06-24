package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Routes;
import ma.ehei.BloomBeauty.repository.RoutesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RouteServicesImplements implements RoutesServices {
    public RoutesRepository routesRepository;

    @Override
    public Routes create(Routes routes) {
        return routesRepository.save(routes);
    }

    @Override
    public List<Routes> read() {
        return routesRepository.findAll();
    }

    @Override
    public Routes update(Long id, Routes routes) {
        return routesRepository.findById(id)
                .map(ctl -> {
                    ctl.setRouteKey(routes.getRouteKey());
                    ctl.setTitre(routes.getTitre());

                    return routesRepository.save(ctl);
                })
                .orElseThrow(() -> new RuntimeException("Route introuvable"));
    }

    @Override
    public String delete(Long id) {
        routesRepository.deleteById(id);
        return "Bien supprimé";
    }
}

