package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;

import ma.ehei.BloomBeauty.entity.Commande;
import ma.ehei.BloomBeauty.services.CommandeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Commande")
@AllArgsConstructor
public class CommandeController {
    @Autowired
    private final CommandeServices commandeService;

    @GetMapping("/getAllCommandes")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/getCommandeById/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = commandeService.getCommandeById(id);
        if (commande == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(commande);
    }

    @PostMapping("/saveCommande/")
    public ResponseEntity<Commande> saveCommande(@RequestBody Commande commande) {
        commande = commandeService.saveCommande(commande);
        return ResponseEntity.status(HttpStatus.CREATED).body(commande);
    }

    @PutMapping("/updateCommande/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        if (!commandeService.getCommandeById(id).getId().equals(commande.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        commande = commandeService.updateCommande(commande);
        return ResponseEntity.ok(commande);
    }

    @DeleteMapping("/deleteCommandeById/{id}")
    public ResponseEntity<Void> deleteCommandeById(@PathVariable Long id) {
        commandeService.deleteCommandeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}




