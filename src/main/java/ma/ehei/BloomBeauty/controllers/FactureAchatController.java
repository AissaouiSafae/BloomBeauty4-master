package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;

import ma.ehei.BloomBeauty.entity.FactureAchat;
import ma.ehei.BloomBeauty.services.FactureAchatServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FactureAchat")
@AllArgsConstructor
public class FactureAchatController {
    private final FactureAchatServices factureAchatServices;

    @GetMapping("/read")
    public List<FactureAchat> read() {


        return factureAchatServices.read();
    }

    @PostMapping("/create")
    public  FactureAchat create(@RequestBody FactureAchat  factureAchat) {
        return factureAchatServices.create(factureAchat);
    }



    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        return factureAchatServices.delete(id);

    }

    @PutMapping("/update/{id}")
    public FactureAchat update(@PathVariable Long id, @RequestBody  FactureAchat factureAchat) {

        return factureAchatServices.update(id,factureAchat );
    }

}
