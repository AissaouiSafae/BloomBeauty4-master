package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;

import ma.ehei.BloomBeauty.entity.Fournisseur;
import ma.ehei.BloomBeauty.entity.Roles;
import ma.ehei.BloomBeauty.entity.Ville;
import ma.ehei.BloomBeauty.services.FournisseurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Fournisseur")
@AllArgsConstructor
@CrossOrigin("http://localhost:3011/metronic8/react/demo8")

public class FournisseurController {

    private final FournisseurServices fournisseurServices;

    @GetMapping("/read")
    public ResponseEntity<List<Fournisseur>> read(){

        return new ResponseEntity<>(fournisseurServices.read(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Long id) {
        Fournisseur fournisseur = fournisseurServices.getFournisseurById(id);
        if (fournisseur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fournisseur);
    }
    @PostMapping("/create")
    public  Fournisseur create(@RequestBody Fournisseur  fournisseur) {
        return fournisseurServices.create(fournisseur);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        return fournisseurServices.delete(id);

    }

    @PutMapping("/update/{id}")
    public Fournisseur update(@PathVariable Long id, @RequestBody  Fournisseur fournisseur) {

        return fournisseurServices.update(fournisseur);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Fournisseur>>search(@RequestParam("keyword") String keyword) {
        List<Fournisseur> fournisseurs = fournisseurServices.findByKeyword(keyword);
        return ResponseEntity.ok(fournisseurs);
    }

}
