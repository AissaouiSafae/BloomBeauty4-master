package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.*;
import ma.ehei.BloomBeauty.services.AttributServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Attribut")
@AllArgsConstructor
public class AttributController {

    @Autowired
    private final AttributServices attributService;

    @GetMapping("/getAllAttributs")
    public List<Attribut> getAllAttributs() {
        return attributService.read();
    }

    @GetMapping("/getAttributById/{id}")
    public ResponseEntity<Attribut> getAttributById(@PathVariable(value = "id") Long attributId) {
        Attribut attribut = attributService.getAttributById(attributId);
        return ResponseEntity.ok().body(attribut);
    }

    @PostMapping("/createAttribut")
    public ResponseEntity<Attribut> createAttribut(@RequestBody Attribut attribut) {
        Attribut createdAttribut = attributService.create(attribut);
        return new ResponseEntity<>(createdAttribut, HttpStatus.CREATED);
    }

    @PutMapping("/updateAttribut/{id}")
    public Attribut updateAttribut(@PathVariable Long id, @RequestBody Attribut attribut) {
        return attributService.update(id, attribut);
    }
    @DeleteMapping("/deleteAttribut/{id}")
    public ResponseEntity<String> deleteAttribut(@PathVariable("id") Long id) {
        attributService.delete(id);
        return new ResponseEntity<>("Attribut supprimée avec succès", HttpStatus.OK);
    }
    @GetMapping("/{id}/Produits")
    public List<Produit> getProduitsByAttribut(@PathVariable("id") Long id) {
        return attributService.getProduitsByAttribut(id);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Attribut>> searchAttributs(@RequestParam("q") String keyword) {
        List<Attribut> attributs = attributService.findByKeyword(keyword);
        return new ResponseEntity<>(attributs, HttpStatus.OK);
    }

}
