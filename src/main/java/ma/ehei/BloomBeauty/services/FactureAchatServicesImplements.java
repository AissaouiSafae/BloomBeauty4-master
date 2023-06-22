package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.FactureAchat;
import ma.ehei.BloomBeauty.repository.FactureAchatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FactureAchatServicesImplements implements FactureAchatServices{

    public static FactureAchatRepository factureAchatRepository;
    @Override
    public FactureAchat create(FactureAchat factureAchat) {
        return factureAchatRepository.save(factureAchat);
    }

    @Override
    public List<FactureAchat> read() {
        return factureAchatRepository.findAll();
    }

    @Override
    public FactureAchat update(Long id, FactureAchat factureAchat) {
        return factureAchatRepository.findById(id)
                .map(clt->{

                    clt.setTotal(factureAchat.getTotal());
                    clt.setTotalLettre(factureAchat.getTotalLettre());
                    clt.setTotalLettre(factureAchat.getTotalLettre());
                    return factureAchat;


                }).orElseThrow(() -> new RuntimeException("factureAchat introuvable"));
    }

    @Override
    public String delete(Long id) {
        factureAchatRepository.deleteById(id);
        return "bien supprimer";
    }
}
