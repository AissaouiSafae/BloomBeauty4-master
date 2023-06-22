package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.AdressLivrason;
import ma.ehei.BloomBeauty.entity.Categorie;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategorieServices {
    Categorie create (Categorie categorie);
    List<Categorie> read();
    Categorie update (Long id,Categorie categorie);
    String delete(Long id);
    public List<Categorie> findByKeyword(String keyword);
    Categorie getCategorieById(Long categorieId);
}
