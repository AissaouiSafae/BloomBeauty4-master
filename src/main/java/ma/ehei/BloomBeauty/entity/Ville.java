package ma.ehei.BloomBeauty.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Ville")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ville implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameFr;

    public Ville(long id) {
        this.id = id;
    }

  @OneToMany(mappedBy = "ville", cascade = CascadeType.MERGE)
  @JsonIgnoreProperties("ville")
    private List<Fournisseur> fournisseurs;
}

