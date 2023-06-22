package ma.ehei.BloomBeauty.controller;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Retour;

import ma.ehei.BloomBeauty.services.RetourServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/retours")
@AllArgsConstructor
public class RetourController {

    @Autowired
    private final RetourServices retourService;

    @GetMapping("/getAllRetours")
    public ResponseEntity<List<Retour>> getAllRetours(){
        List<Retour> list = retourService.getAllRetours();
        return new ResponseEntity<List<Retour>>(list, HttpStatus.OK);
    }

    @GetMapping("/getRetourById/{id}")
    public ResponseEntity<Retour> getRetourById(@PathVariable("id") Long id){
        Retour retour = retourService.getRetourById(id);
        return new ResponseEntity<Retour>(retour, HttpStatus.OK);
    }

    @PostMapping("/createOrUpdateRetour")
    public ResponseEntity<String> createOrUpdateRetour(@RequestBody Retour retour){
        retourService.saveOrUpdateRetour(retour);
        return new ResponseEntity<String>("Retour ajouté/modifié avec succès", HttpStatus.OK);
    }

    @DeleteMapping("deleteRetour/{id}")
    public ResponseEntity<String> deleteRetour(@PathVariable("id") Long id){
        retourService.deleteRetour(id);
        return new ResponseEntity<String>("Retour supprimé avec succès", HttpStatus.OK);
    }

}