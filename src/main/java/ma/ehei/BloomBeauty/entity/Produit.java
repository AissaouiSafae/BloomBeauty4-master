package ma.ehei.BloomBeauty.entity;

import java.io.Serializable;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="Produit") // optionel sinon il prend le nom de la classe
@Data //getters et setters
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameFr;

    @Column(length = 150)
    private String description;

    @Column(nullable = false)
    private String slug;
    @Column(name = "image_url")
    private String imageUrl;



    @ManyToOne()
    @JoinColumn(name = "attribut")
    @JsonIgnoreProperties("produits")
    private Attribut attribut;

    @ManyToOne()
    @JoinColumn(name = "categorie")
    @JsonIgnoreProperties("produits")
    private Categorie categorie;


    @OneToMany(mappedBy = "produit", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("produit")
    private List<Variante> variantes;
    public String getSlug() {
        return this.nameFr.toLowerCase().replaceAll(" ", "-");
    }

    public Produit(Long id) {
        this.id = id;
    }
}