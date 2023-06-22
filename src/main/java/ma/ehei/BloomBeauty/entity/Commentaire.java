package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Table(name="Commentaire")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commentaire  {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String commentaire;

    @Column(nullable = false)
    private String etoile;

    @Column(nullable = false)
    private Date Date;

    @Column(nullable = false)
    private String etat;

    @ManyToOne()
    @JoinColumn(name = "VarianteId")
    private Variante variante;


}