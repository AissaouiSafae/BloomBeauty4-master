package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Roles;
import ma.ehei.BloomBeauty.services.RolesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")

public class RolesController {


    private final RolesServices rolesServices;

    @Autowired
    public RolesController(RolesServices rolesServices) {
        this.rolesServices = rolesServices;
    }

    @PostMapping("/create")
    public ResponseEntity<Roles> create(@RequestBody Roles roles) {
        return new ResponseEntity<>(rolesServices.create(roles), HttpStatus.CREATED);
    }

    @GetMapping("read")
    public ResponseEntity<List<Roles>> read() {
        return new ResponseEntity<>(rolesServices.read(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Roles> update(@PathVariable Long id, @RequestBody Roles roles) {
        return new ResponseEntity<>(rolesServices.update(id, roles), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(rolesServices.delete(id), HttpStatus.OK);
    }

}
