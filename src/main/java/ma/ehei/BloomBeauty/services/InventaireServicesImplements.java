package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Inventaire;
import ma.ehei.BloomBeauty.repository.InventaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventaireServicesImplements implements InventaireServices{
   public final InventaireRepository inventaireRepository;
    @Override
    public Inventaire create(Inventaire inventaire)
    {
        return  inventaireRepository.save(inventaire);
    }

    @Override
    public List<Inventaire> read() {
        return inventaireRepository.findAll();
    }

    @Override
    public Inventaire update(Long id, Inventaire inventaire) {

        return inventaireRepository.findById(id)
                .map(ctl->{
                    ctl.setQte(inventaire.getQte());
                    ctl.setDate(inventaire.getDate());
                    ctl.setDescription(inventaire.getDescription());
                    return inventaire;

                }).orElseThrow(() -> new RuntimeException("Inventaire introuvable"));
    }

    @Override
    public String delete(Long id) {
        inventaireRepository.deleteById(id);
        return "Bien Supprimer ";
    }


}
