package ma.ehei.BloomBeauty.services;



import ma.ehei.BloomBeauty.entity.Retour;

import java.util.List;

public interface RetourServices {



    List<Retour> getAllRetours();
    Retour getRetourById(Long id);
    void saveOrUpdateRetour(Retour retour);
    void deleteRetour(Long id);


}
