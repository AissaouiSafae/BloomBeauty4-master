package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.ehei.BloomBeauty.entity.Fournisseur;
import ma.ehei.BloomBeauty.entity.Ville;
import ma.ehei.BloomBeauty.services.VilleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/villes")
public class VilleController {
    @Autowired
    private final VilleServices villeServices;


    public VilleController(VilleServices villeServices) {
        this.villeServices = villeServices;
    }

    @GetMapping("/getAllVilles")
    public ResponseEntity<List<Ville>> getAllVilles() {
        List<Ville> villes = villeServices.read();
        return new ResponseEntity<>(villes, HttpStatus.OK);
    }

    @GetMapping("/getVilleById/{id}")
    public ResponseEntity<Ville> getVilleById(@PathVariable("id") Long id) {
        Ville ville = villeServices.findById(id);
        return new ResponseEntity<>(ville, HttpStatus.OK);
    }

    @PostMapping("/createVille")
    public ResponseEntity<Ville> createVille(@RequestBody Ville ville) {
        Ville createdVille = villeServices.create(ville);
        return new ResponseEntity<>(createdVille, HttpStatus.CREATED);
    }

    @PutMapping("/updateVille/{id}")
    public ResponseEntity<Ville> updateVille(@PathVariable("id") Long id, @RequestBody Ville ville) {
        Ville updatedVille = villeServices.update(id, ville);
        return new ResponseEntity<>(updatedVille, HttpStatus.OK);
    }

    @DeleteMapping("/deleteVille/{id}")
    public ResponseEntity<String> deleteVille(@PathVariable("id") Long id) {
        villeServices.delete(id);
        return new ResponseEntity<>("Ville supprimée avec succès", HttpStatus.OK);
    }

    @GetMapping("/{id}/fournisseurs")
    public List<Fournisseur> getFournisseursByVille(@PathVariable("id") Long villeId) {
        return villeServices.getFournisseursByVille(villeId);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Ville>> searchVilles(@RequestParam("q") String keyword) {
        List<Ville> villes = villeServices.findByKeyword(keyword);
        return new ResponseEntity<>(villes, HttpStatus.OK);
    }

}
