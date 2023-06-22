package ma.ehei.BloomBeauty.services;

import java.util.List;

import ma.ehei.BloomBeauty.entity.VariantePanier;

public interface VariantePanierService {

    public List<VariantePanier> getAllVariantesPanier();

    public VariantePanier getVariantePanierById(Long id);

    public VariantePanier saveVariantePanier(VariantePanier variantePanier);

    public void deleteVariantePanierById(Long id);

}