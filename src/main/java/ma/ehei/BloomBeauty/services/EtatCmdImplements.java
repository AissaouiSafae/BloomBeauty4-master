package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.EtatCmd;
import ma.ehei.BloomBeauty.repository.EtatCmdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtatCmdImplements implements EtatCmdServices{
    public final EtatCmdRepository etatCmdRepository;
    @Override
    public EtatCmd create(EtatCmd etatCmd) {
        return etatCmdRepository.save(etatCmd);
    }

    @Override
    public List<EtatCmd> read() {
        return etatCmdRepository.findAll();
    }

    @Override
    public EtatCmd update(Long id, EtatCmd etatCmd) {
        return etatCmdRepository.findById(id)
                .map(clt->{
                    clt.setDate(etatCmd.getDate());
                    return etatCmd;


                }).orElseThrow(() -> new RuntimeException("EtatCmd introuvable"));

    }

    @Override
    public String delete(Long id) {
        return "bien supprimer";
    }
}
