package ma.ehei.BloomBeauty.services;



import ma.ehei.BloomBeauty.entity.Offres;

import java.util.List;

public interface OffresServices {
    Offres create (Offres offres);
    List<Offres> read();
    Offres update (Long id, Offres  offres);
    String delete(Long id);
}
