package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.OffresVariante;
import ma.ehei.BloomBeauty.repository.OffresVarianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class OffresVarianteServicesImplements implements OffresVarianteServices{
    OffresVarianteRepository offresVarianteRepository;
    @Override
    public OffresVariante create(OffresVariante offresVariante) {
        return offresVarianteRepository.save(offresVariante);
    }

    @Override
    public List<OffresVariante> read() {
        return offresVarianteRepository.findAll();
    }

    @Override
    public OffresVariante update(Long id, OffresVariante offresVariante) {

        return offresVarianteRepository.findById(id)
                .map(offresVar->{
                    offresVar.setOffres(offresVariante.getOffres());
                    offresVar.setVariante(offresVariante.getVariante());
                    return offresVarianteRepository.save(offresVar);
                })
                .orElseThrow(() -> new RuntimeException("OffresVariante introuvable"));

    }

    @Override
    public String delete(Long id) {
        offresVarianteRepository.deleteById(id);
        return "Bien Supprimer ";
    }
}
