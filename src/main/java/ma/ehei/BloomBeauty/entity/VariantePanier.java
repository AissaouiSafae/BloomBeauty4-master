package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="VariantePanier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VariantePanier {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private float Pu;

    @Column(nullable = false)
    private int Qnt;



    @ManyToOne()
    @JoinColumn(name = "PanierTemporaire")
    private PanierTemporaire panierTemporaire;

    @ManyToOne()
    @JoinColumn(name = "Variante")
    private Variante variante;

}
