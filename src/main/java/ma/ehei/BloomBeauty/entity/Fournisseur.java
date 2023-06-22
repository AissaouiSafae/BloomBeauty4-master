package ma.ehei.BloomBeauty.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Fournisseur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fournisseur implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String NameFr;

    @Column(nullable = false)
    private String banque;

    @Column(nullable = false)
    private Long rib;


    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name="fournisseur")
    private List<FactureAchat> factureAchats;



   @ManyToOne
    @JoinColumn(name = "ville")
  //@JsonBackReference
   @JsonIgnoreProperties("fournisseurs")
    private Ville ville;
}

