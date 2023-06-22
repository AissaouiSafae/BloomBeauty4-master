package ma.ehei.BloomBeauty.services;



import ma.ehei.BloomBeauty.entity.Fournisseur;

import java.util.List;

public interface FournisseurServices {

    Fournisseur create (Fournisseur fournisseur);
    Fournisseur getFournisseurById(Long id);
    List<Fournisseur> findByKeyword(String keyword);
    List<Fournisseur> read();
    Fournisseur update (Fournisseur  fournisseur);

    String delete(Long id);
   // public  List<Fournisseur> search(String keyword);

}
