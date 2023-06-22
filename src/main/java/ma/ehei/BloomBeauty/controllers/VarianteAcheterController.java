package ma.ehei.BloomBeauty.controllers;
import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.VarianteAchetee;
import ma.ehei.BloomBeauty.services.VarianteAcheteeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variantes-achetees")
@AllArgsConstructor
public class VarianteAcheterController {

    @Autowired
    private final VarianteAcheteeServices varianteAcheteeServices;

    @GetMapping("/getVariantesAchetees")
    public List<VarianteAchetee> getVariantesAchetees() {
        return varianteAcheteeServices.read();
    }

    @PostMapping("/createVarianteAchetee")
    public VarianteAchetee createVarianteAchetee(@RequestBody VarianteAchetee varianteAchetee) {
        return varianteAcheteeServices.create(varianteAchetee);
    }

    @PutMapping("/updateVarianteAchetee/{id}")
    public VarianteAchetee updateVarianteAchetee(@PathVariable Long id, @RequestBody VarianteAchetee varianteAchetee) {
        return varianteAcheteeServices.update(id, varianteAchetee);
    }

    @DeleteMapping("/deleteVarianteAchetee/{id}")
    public String deleteVarianteAchetee(@PathVariable Long id) {
        return varianteAcheteeServices.delete(id);
    }
}
