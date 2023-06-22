package ma.ehei.BloomBeauty.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Variante")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Variante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonProperty("nameFr")
    private String nameFr;

    @Column(length = 150)
    private String description;

    @Column(nullable = false)
    private float prix;

    @Column(length = 150)
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "produit")
    @JsonIgnoreProperties("variantes")
    private Produit produit;


    @OneToMany(mappedBy = "variante", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("variante")
   // @JsonManagedReference
    //@JsonProperty("images") // Utiliser cette propriété lors de la sérialisation de Image
    //@JsonManagedReference("variante") // Sérialise cette propriété lors de la sérialisation de Image
    private List<Image> images;
    /*public Variante() {
        this.images = new ArrayList<>();//composition
    }*/
    /*public void addImage(Image image) {
        images.add(image);
        image.setVariante(this);
    }

    public void removeImage(Image image) {
        images.remove(image);
        image.setVariante(null);
    }*/

    @OneToMany(mappedBy = "variante", cascade = CascadeType.MERGE)
    private List<Commentaire> commentaires;


}