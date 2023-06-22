package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.OffresVariante;
import ma.ehei.BloomBeauty.services.OffresVarianteServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offres_variante")
@AllArgsConstructor
public class OffresVarianteController {

    private final OffresVarianteServices offresVarianteServices;

    @PostMapping("/create")
    public OffresVariante create(@RequestBody OffresVariante offresVariante) {
        return offresVarianteServices.create(offresVariante);
    }

    @GetMapping("/read")
    public List<OffresVariante> read() {
        return offresVarianteServices.read();
    }

    @PutMapping("/update/{id}")
    public OffresVariante update(@PathVariable("id") Long id, @RequestBody OffresVariante offresVariante) {
        return offresVarianteServices.update(id, offresVariante);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return offresVarianteServices.delete(id);
    }
}
