package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Categorie;
import ma.ehei.BloomBeauty.repository.CategorieRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategorieServicesImplements implements CategorieServices{
    public final CategorieRepository categorieRepository;
    @Override
    public Categorie create(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> read() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie update(Long id, Categorie categorie) {
        return categorieRepository.findById(id)
                .map(clt-> {
                    clt.setNameFr(categorie.getNameFr());
                    clt.setParent(categorie.getParent());
                    clt.setPriorite(categorie.getPriorite());
                    clt.setDescription(categorie.getDescription());
                    clt.setIcon(categorie.getIcon());

                    if (!StringUtils.isEmpty(categorie.getImageUrl())) {
                        clt.setImageUrl(categorie.getImageUrl());
                    }

                    categorieRepository.save(clt);
                    return categorie;

                }).orElseThrow(() -> new RuntimeException("Attribut introuvable"));
    }


    @Override
    public List<Categorie> findByKeyword(String keyword) {
        return categorieRepository.findByKeyword(keyword);
    }

    @Override
    public String delete(Long id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        if (categorie.isPresent()) {
            Categorie parent = categorie.get();
            deleteSubcategories(parent);
            categorieRepository.delete(parent);
            return "Successfully deleted parent category and its subcategories.";
        } else {
            return "Category not found.";
        }
    }

    private void deleteSubcategories(Categorie parent) {
        List<Categorie> subcategories = categorieRepository.findByParent(parent.getId());
        for (Categorie subcategory : subcategories) {
            deleteSubcategories(subcategory); // recursively delete subcategories
            categorieRepository.delete(subcategory);
        }
    }

    @Override
    public Categorie getCategorieById(Long id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found")
                );
    }
}
