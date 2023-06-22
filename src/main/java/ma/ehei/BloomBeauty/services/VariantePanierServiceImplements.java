package ma.ehei.BloomBeauty.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ehei.BloomBeauty.entity.VariantePanier;
import ma.ehei.BloomBeauty.repository.VariantePanierRepository;

@Service
public class VariantePanierServiceImplements implements VariantePanierService {

    @Autowired
    private VariantePanierRepository variantePanierRepository;

    @Override
    public List<VariantePanier> getAllVariantesPanier() {
        return variantePanierRepository.findAll();
    }

    @Override
    public VariantePanier getVariantePanierById(Long id) {
        return variantePanierRepository.findById(id).orElse(null);
    }

    @Override
    public VariantePanier saveVariantePanier(VariantePanier variantePanier) {
        return variantePanierRepository.save(variantePanier);
    }

    @Override
    public void deleteVariantePanierById(Long id) {
        variantePanierRepository.deleteById(id);
    }

}