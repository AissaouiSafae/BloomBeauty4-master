package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Offres;
import ma.ehei.BloomBeauty.services.OffresServices;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offres")
@AllArgsConstructor
public class OffresController {

    private final OffresServices offresServices;

    @GetMapping("/getOffres")
    public List<Offres> getOffres() {
        return offresServices.read();
    }

    @PostMapping("/addOffre")
    public Offres addOffre(@RequestBody Offres offres) {
        return offresServices.create(offres);
    }

    @PutMapping("/updateOffre/{id}")
    public Offres updateOffre(@PathVariable Long id, @RequestBody Offres offres) {
        return offresServices.update(id, offres);
    }

    @DeleteMapping("/deleteOffre/{id}")
    public String deleteOffre(@PathVariable Long id) {
        return offresServices.delete(id);
    }


    // pour afficher les offres dans un carouse et slide
    @GetMapping("/offres")
    public String offres(Model model) {
        List<Offres> offres = offresServices.read();
        model.addAttribute("offres", offres);
        return "offres";
    }

}
