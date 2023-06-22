package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.varianteCommande;
import ma.ehei.BloomBeauty.services.varianteCommandeServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/VarianteCommande")
@AllArgsConstructor

public class VarianteCommandeController {
    private   final varianteCommandeServices varianteCommandeServices;
    @PostMapping("/create")
    public varianteCommande create(@RequestBody varianteCommande varianteCommande) {
        return varianteCommandeServices.create(varianteCommande);
    }

    @GetMapping("/read")
    public List<varianteCommande> read() {
        return varianteCommandeServices.read();
    }

    @PutMapping("/update/{id}")
    public varianteCommande update(@PathVariable Long id, @RequestBody varianteCommande varianteCommande) {
        return varianteCommandeServices.update(id, varianteCommande);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return varianteCommandeServices.delete(id);
    }
}
