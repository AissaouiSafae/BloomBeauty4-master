package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Variante;
import ma.ehei.BloomBeauty.repository.VarianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VarianteServicesImplements implements VarianteServices{
     public final VarianteRepository varianteRepository;
    @Override
    public Variante create(Variante variante) {
        return varianteRepository.save(variante);
    }

    @Override
    public List<Variante> read() {
        return varianteRepository.findAll(); }

    @Override
    public Variante update(Long id, Variante variante) {
        return varianteRepository.findById(id)
                .map(ctl->{
                    ctl.setNameFr(variante.getNameFr());
                    ctl.setDescription(variante.getDescription());
                    ctl.setPrix(variante.getPrix());
                    ctl.setCommentaires(variante.getCommentaires());
                    return varianteRepository.save(ctl);
                }).orElseThrow(() -> new RuntimeException("variante introuvable"));
    }

    @Override
    public String delete(Long id) {
        return "Bien Supprimer";
    }

    @Override
    public Optional<Variante> getVarianteById(Long id) {
        return varianteRepository.findById(id);
    }
}
