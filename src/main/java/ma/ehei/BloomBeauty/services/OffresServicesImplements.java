package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Offres;
import ma.ehei.BloomBeauty.repository.OffresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OffresServicesImplements implements OffresServices{
    OffresRepository offresRepository;
    @Override
    public Offres create(Offres offres) {
        return offresRepository.save(offres);
    }

    @Override
    public List<Offres> read() {
        return offresRepository.findAll();
    }

    @Override
    public Offres update(Long id, Offres offres )
    {
return offresRepository.findById(id)
        .map(ctl->{
            ctl.setTitre(offres.getTitre());
            ctl.setImage(offres.getImage());
            ctl.setType(offres.getType());
            ctl.setLien(offres.getLien());
            ctl.setDescription(offres.getDescription());
            ctl.setDateDebut(offres.getDateDebut());
            ctl.setDateFin(offres.getDateFin());
            ctl.setDateCreation(offres.getDateCreation());
            return  offres;

        }).orElseThrow(() -> new RuntimeException("offres introuvable"));
    }

    @Override
    public String delete(Long id) {
        offresRepository.deleteById(id);
        return "Bien Supprimer";
    }
}
