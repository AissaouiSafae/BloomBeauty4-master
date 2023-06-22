package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Roles;
import ma.ehei.BloomBeauty.repository.RolesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class RolesServicesImplements implements RolesServices{
    public final RolesRepository rolesRepository;
    @Override
    public Roles create(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public List<Roles> read() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles update(Long id, Roles roles) {
        return rolesRepository.findById(id)
                .map(ctl->{
                    ctl.setNomfr(roles.getNomfr());
                    ctl.setPriorite(roles.getPriorite());
                    return roles;
                }).orElseThrow(() -> new RuntimeException("role introuvable"));
    }

    @Override
    public String delete(Long id) {
        rolesRepository.deleteById(id);
        return "Bien Supprimer ";
    }
}
