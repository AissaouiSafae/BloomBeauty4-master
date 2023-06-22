package ma.ehei.BloomBeauty.controllers;
import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Etat;

import ma.ehei.BloomBeauty.services.EtatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etats")
@AllArgsConstructor
public class EtatController {
    @Autowired
    private final EtatService etatService;

    @GetMapping("getAllEtats/read")
    public ResponseEntity<List<Etat>> getAllEtats() {
        List<Etat> etats = etatService.getAllEtats();
        return new ResponseEntity<>(etats, HttpStatus.OK);
    }

    @GetMapping("/ getEtatById/{id}")
    public ResponseEntity<Etat> getEtatById(@PathVariable Long id) {
        Etat etat = etatService.getEtatById(id);
        return new ResponseEntity<>(etat, HttpStatus.OK);
    }

    @PostMapping("/createEtat")
    public ResponseEntity<Etat> createEtat(@RequestBody Etat etat) {
        Etat savedEtat = etatService.saveOrUpdateEtat(etat);
        return new ResponseEntity<>(savedEtat, HttpStatus.CREATED);
    }

    @PutMapping("/updateEtat/{id}")
    public ResponseEntity<Etat> updateEtat(@PathVariable Long id, @RequestBody Etat etat) {
        if (etat.getId() == null || !etat.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Etat updatedEtat = etatService.saveOrUpdateEtat(etat);
        return new ResponseEntity<>(updatedEtat, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEtat/{id}")
    public ResponseEntity<Void> deleteEtat(@PathVariable Long id) {
        etatService.deleteEtat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
