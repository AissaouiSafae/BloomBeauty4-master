package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Inventaire;
import ma.ehei.BloomBeauty.services.InventaireServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventaires")
@AllArgsConstructor
public class InventaireController {

    @Autowired
    private final InventaireServices inventaireServices;

    @PostMapping("/create")
    public Inventaire create(@RequestBody Inventaire inventaire) {
        return inventaireServices.create(inventaire);
    }

    @GetMapping("/read")
    public List<Inventaire> read() {
        return inventaireServices.read();
    }

    @PutMapping("/{id}")
    public Inventaire update(@PathVariable Long id, @RequestBody Inventaire inventaire) {
        return inventaireServices.update(id, inventaire);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return inventaireServices.delete(id);
    }
}
