package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.VarianteAchetee;
import ma.ehei.BloomBeauty.repository.VarianteAcheteeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class VarianteAcheteeServicesImplements implements VarianteAcheteeServices{
     public final VarianteAcheteeRepository varianteAcheteeRepository;
    @Override
    public VarianteAchetee create(VarianteAchetee varianteAchetee) {
        return varianteAcheteeRepository.save(varianteAchetee);
    }

    @Override
    public List<VarianteAchetee> read() {
        return varianteAcheteeRepository.findAll();
    }

    @Override
    public VarianteAchetee update(Long id, VarianteAchetee varianteAchetee) {

        return varianteAcheteeRepository.findById(id)
                .map(ctl->{
                    ctl.setQte(varianteAchetee.getQte());
                    return varianteAchetee;
                }).orElseThrow(() -> new RuntimeException("vaianteAchetee introuvable"));
    }

    @Override
    public String delete(Long id) {
        return "Bien Supprimer ";
    }
}
