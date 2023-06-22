package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Produit;
import ma.ehei.BloomBeauty.repository.ProduitRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProduitServicesImplements implements ProduitServices{
    private final ProduitRepository produitRepository;

    @Override
    public Produit create(Produit produit) {
        String slug = generateSlug(produit.getNameFr()); // générer le slug à partir du nom du produit
        produit.setSlug(slug); // ajouter le slug à l'objet produit
        return produitRepository.save(produit);
    }
    private String generateSlug(String nom) {
        // implémenter un algorithme pour générer le slug à partir du nom du produit
        // par exemple, remplacer les espaces par des tirets et convertir en minuscules
        return nom.toLowerCase().replaceAll(" ", "-").toLowerCase();
    }
    @Override
    public List<Produit> findAllWithCategoriesAndAttributes() {
        return produitRepository.findAllWithCategoriesAndAttributes();
    }

    @Override
    public List<Produit> read() {
        return produitRepository.findAll();
    }
    /*public List<Produit> read() {
        List<Produit> produits = produitRepository.findAll();
        for (Produit produit : produits) {
            produit.getCategorie().setProduit(null);
        }
        return produits;
    }*/


    @Override
    public Produit update(Long id, Produit produit) {
        Optional<Produit> existingProduct = produitRepository.findById(id);
        if (existingProduct.isPresent()) {
            Produit updatedProduct = existingProduct.get();
            updatedProduct.setNameFr(produit.getNameFr());
            String slug = generateSlug(produit.getNameFr()); // générer le slug à partir du nom du produit
            updatedProduct.setSlug(slug);
            updatedProduct.setDescription(produit.getDescription());
            if (!StringUtils.isEmpty(produit.getImageUrl())) {
                updatedProduct.setImageUrl(produit.getImageUrl());
            }
            updatedProduct.setAttribut(produit.getAttribut());
            updatedProduct.setCategorie(produit.getCategorie());
            updatedProduct.setVariantes(produit.getVariantes());
            return produitRepository.save(updatedProduct);
        } else {
            throw new RuntimeException("Produit introuvable");
        }
    }

    @Override
    public String delete(Long id) {
        produitRepository.deleteById(id);
        return "bien supprimer";
    }

    @Override
    public Produit getProductById(Long id) {
        Optional<Produit> product = produitRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException("Produit introuvable"));
    }
    @Override
    public List<Produit> findByKeyword(String keyword) {
        return produitRepository.searchByKeyword(keyword);
    }

}
