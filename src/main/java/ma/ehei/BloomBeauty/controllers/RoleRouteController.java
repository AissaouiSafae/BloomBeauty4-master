package ma.ehei.BloomBeauty.controllers;


import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.RoleRoute;
import ma.ehei.BloomBeauty.services.RoleRouteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roleRoutes")
@AllArgsConstructor
public class RoleRouteController {
    @Autowired
    private RoleRouteServices roleRouteServices;

    @GetMapping("/getAllRoleRoutes")
    public ResponseEntity<List<RoleRoute>> getAllRoleRoutes() {
        List<RoleRoute> roleRoutes = roleRouteServices.read();
        return new ResponseEntity<>(roleRoutes, HttpStatus.OK);
    }

    @PostMapping("/createRoleRoute")
    public ResponseEntity<RoleRoute> createRoleRoute(@RequestBody RoleRoute roleRoute) {
        RoleRoute createdRoleRoute = roleRouteServices.create(roleRoute);
        return new ResponseEntity<>(createdRoleRoute, HttpStatus.CREATED);
    }

    @PutMapping("/updateRoleRoute/{id}")
    public ResponseEntity<RoleRoute> updateRoleRoute(@PathVariable Long id, @RequestBody RoleRoute roleRoute) {
        RoleRoute updatedRoleRoute = roleRouteServices.update(id, roleRoute);
        return new ResponseEntity<>(updatedRoleRoute, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRoleRoute/{id}")
    public ResponseEntity<String> deleteRoleRoute(@PathVariable Long id) {
        String message = roleRouteServices.delete(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
