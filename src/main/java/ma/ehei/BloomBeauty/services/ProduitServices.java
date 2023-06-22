package ma.ehei.BloomBeauty.services;



import ma.ehei.BloomBeauty.entity.Produit;

import java.util.List;

public interface ProduitServices {
    Produit create (Produit produit);
    List<Produit > read();
    Produit  update (Long id, Produit  produit);
    List<Produit> findAllWithCategoriesAndAttributes();
    String delete(Long id);
    List<Produit> findByKeyword(String keyword); //méthode pour chercher un produit par mot-clé

    Produit getProductById(Long id);
}

