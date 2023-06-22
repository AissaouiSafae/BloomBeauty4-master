package ma.ehei.BloomBeauty.entity;


import java.io.Serializable;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Attribut")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Attribut implements Serializable {

//	private static final long serialVersionUID = -8491828021685868418L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String NameFr;

    @Column(length = 150)
    private String description;
    @Column(length = 150)
    private String option;


    @Column(nullable = true)
    private String icon;

    public Attribut(long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "attribut", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("attribut")
    private List<Produit> produits;


}