package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Attribut;
import ma.ehei.BloomBeauty.entity.Produit;
import ma.ehei.BloomBeauty.entity.Ville;
import ma.ehei.BloomBeauty.repository.AttributRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AttributServicesImplementation implements AttributServices{
    public  final AttributRepository attributRepository;
    @Override
    public Attribut create(Attribut attribut) {
        return attributRepository.save(attribut);
    }

    @Override
    public List<Attribut> read() {
        return attributRepository.findAll();

    }

    @Override
    public Attribut update(Long id, Attribut attribut) {
       return attributRepository.findById(id)
                .map(clt -> {
                    clt.setNameFr(attribut.getNameFr());
                    clt.setDescription(attribut.getDescription());
                    clt.setOption(attribut.getOption());
                    clt.setIcon(attribut.getIcon());
                    attributRepository.save(clt);
                    return attribut;
                }).orElseThrow(() -> new RuntimeException("Attribut introuvable"));

    }
    @Override
    public String delete(Long id) {
        attributRepository.deleteById(id);
        return "bien suprimer";
    }

    @Override
    public Attribut getAttributById(Long id) {
        return attributRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found")
                );
    }
    @Override
    public List<Produit> getProduitsByAttribut(Long id) {
        Attribut attribut = attributRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("attribut introuvable"));
        return attribut.getProduits();
    }
    @Override
    public List<Attribut> findByKeyword(String keyword) {
        return attributRepository.findByKeyword(keyword);
    }
}
