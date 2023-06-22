package ma.ehei.BloomBeauty.controllers;


import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.VarianteRetour;
import ma.ehei.BloomBeauty.services.VarianteRetourServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/VarianteRetour")
@AllArgsConstructor
public class VarianteRetourController {

    @Autowired
    private final VarianteRetourServices varianteRetourService;

    @GetMapping("/getAllVariantesRetour")
    public List<VarianteRetour> getAllVariantesRetour() {
        return varianteRetourService.findAll();
    }

    @GetMapping("/getVarianteRetourById/{id}")
    public ResponseEntity<VarianteRetour> getVarianteRetourById(@PathVariable(value = "id") Long id) {
        VarianteRetour varianteRetour = varianteRetourService.findById(id);
        if (varianteRetour == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(varianteRetour);
    }

    @PostMapping("/createVarianteRetour")
    public VarianteRetour createVarianteRetour(@RequestBody VarianteRetour varianteRetour) {
        return varianteRetourService.save(varianteRetour);
    }

    @DeleteMapping("/deleteVarianteRetourById/{id}")
    public ResponseEntity<Void> deleteVarianteRetourById(@PathVariable(value = "id") Long id) {
        VarianteRetour varianteRetour = varianteRetourService.findById(id);
        if (varianteRetour == null) {
            return ResponseEntity.notFound().build();
        }
        varianteRetourService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}








