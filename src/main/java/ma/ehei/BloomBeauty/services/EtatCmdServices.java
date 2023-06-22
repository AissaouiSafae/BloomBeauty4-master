package ma.ehei.BloomBeauty.services;



import ma.ehei.BloomBeauty.entity.EtatCmd;

import java.util.List;

public interface EtatCmdServices {
    EtatCmd create (EtatCmd etatCmd);
    List<EtatCmd> read();
    EtatCmd update (Long id, EtatCmd  etatCmd);
    String delete(Long id);
}
