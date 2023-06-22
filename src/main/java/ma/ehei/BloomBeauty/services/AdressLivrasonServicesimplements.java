package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.AdressLivrason;
import ma.ehei.BloomBeauty.repository.AdressLivrasonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdressLivrasonServicesimplements implements AdressLivrasonServices {
    public final AdressLivrasonRepository adressLivrasonRepository;

    @Override
    public AdressLivrason create(AdressLivrason adressLivrason) {

        return adressLivrasonRepository.save(adressLivrason) ;
    }

    @Override
    public List<AdressLivrason> read() {
        return adressLivrasonRepository.findAll();
    }

    @Override
    public AdressLivrason update(Long id, AdressLivrason adressLivrason) {

        return adressLivrasonRepository.findById(id)
                .map(clt->{

                    clt.setNom(adressLivrason.getNom());
                    clt.setPrenom(adressLivrason.getPrenom());
                    clt.setTel(adressLivrason.getTel());
                    clt.setEmail(adressLivrason.getEmail());
                    clt.setCodePostal(adressLivrason.getCodePostal());
                    clt.setAdressPostal(adressLivrason.getAdressPostal());
                    clt.setVille(adressLivrason.getVille());

                    return adressLivrason;
    }).orElseThrow(()->new RuntimeException("Client introuvable"));
    }
    @Override
    public String delete(Long id) {
        adressLivrasonRepository.deleteById(id);
        return "bien suprimer";
    }
}
