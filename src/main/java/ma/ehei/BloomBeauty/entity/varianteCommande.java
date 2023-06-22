package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="variante_Commande")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class varianteCommande{

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float Qte;

    @Column(nullable = false)
    private float PU;

    @ManyToOne()
    @JoinColumn(name = "CommandeId")
    private Commande commande;

    @ManyToOne()
    @JoinColumn(name = "VarianteRetourId")
    private VarianteRetour varianteRetour;



}
