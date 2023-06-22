package ma.ehei.BloomBeauty.entity;

import java.io.Serializable;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Categorie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie implements Serializable {


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nameFr;

    @Column(nullable = false)
    private int parent;

    @Column(nullable = false)
    private int priorite;


    @Column(length = 150)
    private String description;

    @Column(name = "image_url")

    private String imageUrl;

    @Column(nullable = false)
    private String icon;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("categorie")
    private List<Produit> produit;


}
