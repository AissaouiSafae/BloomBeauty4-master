package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Retour;
import ma.ehei.BloomBeauty.repository.RetourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetourServicesImplements implements RetourServices{
    @Autowired
    private RetourRepository retourRepository;

    @Override
    public List<Retour> getAllRetours() {
        return retourRepository.findAll();
    }

    @Override
    public Retour getRetourById(Long id) {
        return retourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Retour non trouvé pour l'id :: " + id));
    }
    @Override
    public void saveOrUpdateRetour(Retour retour) {
        retourRepository.save(retour);
    }

    @Override
    public void deleteRetour(Long id) {
        retourRepository.deleteById(id);
    }
}
