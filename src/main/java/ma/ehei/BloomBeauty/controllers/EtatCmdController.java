package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;

import ma.ehei.BloomBeauty.entity.EtatCmd;
import ma.ehei.BloomBeauty.services.EtatCmdServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EtatCmd")
@AllArgsConstructor
public class EtatCmdController {
    private final EtatCmdServices etatCmdServices;

    @GetMapping("/read")
    public List<EtatCmd> read() {


        return etatCmdServices.read();
    }

    @PostMapping("/create")
    public  EtatCmd create(@RequestBody EtatCmd  etatCmd) {
        return etatCmdServices.create(etatCmd);
    }



    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        return etatCmdServices.delete(id);

    }

    @PutMapping("/update/{id}")
    public EtatCmd update(@PathVariable Long id, @RequestBody  EtatCmd etatCmd) {

        return etatCmdServices.update(id,etatCmd );
    }


}
