package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.VarianteRetour;
import ma.ehei.BloomBeauty.repository.VarianteRetourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class VarianteRetourServicesImplements implements VarianteRetourServices{


    @Autowired
    private VarianteRetourRepository varianteRetourRepository;

    @Override
    public VarianteRetour save(VarianteRetour varianteRetour) {
        return varianteRetourRepository.save(varianteRetour);
    }

    @Override
    public void deleteById(Long id) {
        varianteRetourRepository.deleteById(id);
    }

    @Override
    public VarianteRetour findById(Long id) {
        return varianteRetourRepository.findById(id).orElse(null);
    }

    @Override
    public List<VarianteRetour> findAll() {
        return varianteRetourRepository.findAll();
    }
}



