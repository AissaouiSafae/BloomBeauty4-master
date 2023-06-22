package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Utilisateur;
import ma.ehei.BloomBeauty.services.UtilisateurServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
public class UtilisateurController {

    private final UtilisateurServices utilisateurServices;

    @PostMapping("/create")
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {
        return utilisateurServices.create(utilisateur);
    }

    @GetMapping("/read")
    public List<Utilisateur> read() {
        return utilisateurServices.read();
    }

    @PutMapping("/update/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        return utilisateurServices.update(id, utilisateur);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return utilisateurServices.delete(id);
    }
}
