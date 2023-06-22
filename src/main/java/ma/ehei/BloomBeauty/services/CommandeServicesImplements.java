package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Categorie;
import ma.ehei.BloomBeauty.entity.Commande;
import ma.ehei.BloomBeauty.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CommandeServicesImplements implements CommandeServices{



    @Autowired
    private final CommandeRepository commandeRepository;

    @Override
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommandeById(Long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
}
