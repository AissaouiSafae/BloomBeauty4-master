package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Commentaire;
import ma.ehei.BloomBeauty.services.CommentaireServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Commentaire")
@AllArgsConstructor
public class CommentaireController {
    private final CommentaireServices commentaireServices;

    @GetMapping("/read")
    public List<Commentaire> read() {

        return commentaireServices.read();
    }

    @PostMapping("/create")
    public  Commentaire create(@RequestBody Commentaire  commentaire) {
        return commentaireServices.create(commentaire);
    }



    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        return commentaireServices.delete(id);

    }

    @PutMapping("/update/{id}")
    public Commentaire update(@PathVariable Long id, @RequestBody  Commentaire commentaire) {

        return commentaireServices.update(id,commentaire );
    }

}
