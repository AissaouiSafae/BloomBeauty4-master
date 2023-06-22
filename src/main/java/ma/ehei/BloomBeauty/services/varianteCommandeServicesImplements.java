package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.varianteCommande;
import ma.ehei.BloomBeauty.repository.varianteCommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class varianteCommandeServicesImplements implements varianteCommandeServices{
    public final varianteCommandeRepository varianteCommandeRepository;
    @Override
    public varianteCommande create(varianteCommande varianteCommande) {
        return varianteCommandeRepository.save(varianteCommande);
    }

    @Override
    public List<varianteCommande> read() {
        return varianteCommandeRepository.findAll();
    }

    @Override
    public varianteCommande update(Long id, varianteCommande varianteCommande) {

        return varianteCommandeRepository.findById(id)
                .map(ctl->{
                    ctl.setQte(varianteCommande.getQte());
                    ctl.setPU(varianteCommande.getPU());
                    return varianteCommande;
                }).orElseThrow(() -> new RuntimeException("variante Commande introuvable"));
    }

    @Override
    public String delete(Long id) {
        varianteCommandeRepository.deleteById(id);
        return "Bien Supprimer";
    }
}
