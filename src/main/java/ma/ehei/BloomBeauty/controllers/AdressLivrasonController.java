package ma.ehei.BloomBeauty.controllers;


import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.AdressLivrason;
import ma.ehei.BloomBeauty.entity.Attribut;
import ma.ehei.BloomBeauty.services.AdressLivrasonServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AdressLivrason")
@AllArgsConstructor
public class AdressLivrasonController {

    private final AdressLivrasonServices adressLivrasonServices;

    @GetMapping("/read")
    public List<AdressLivrason> read() {

//		System.out.println("Error");
        return adressLivrasonServices.read();
    }

    @PostMapping("/create")
    public  AdressLivrason create(@RequestBody  AdressLivrason  adressLivrason) {
        return adressLivrasonServices.create(adressLivrason);
    }



    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        return adressLivrasonServices.delete(id);

    }

    @PutMapping("/update/{id}")
    public AdressLivrason update(@PathVariable Long id, @RequestBody  AdressLivrason adressLivrason) {

        return adressLivrasonServices.update(id,adressLivrason );
    }

}
