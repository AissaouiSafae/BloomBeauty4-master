package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Routes;
import ma.ehei.BloomBeauty.services.RoutesServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
@AllArgsConstructor

public class RouteController {

    private final RoutesServices routesServices;

    @PostMapping("/create")
    public Routes create(@RequestBody Routes routes) {
        return routesServices.create(routes);
    }

    @GetMapping("/read")
    public List<Routes> read() {
        return routesServices.read();
    }

    @PutMapping("/update/{id}")
    public Routes update(@PathVariable Long id, @RequestBody Routes routes) {
        return routesServices.update(id, routes);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return routesServices.delete(id);
    }
}
