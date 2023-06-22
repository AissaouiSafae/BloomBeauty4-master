package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehei.BloomBeauty.entity.FactureAchat;
import ma.ehei.BloomBeauty.entity.Variante;

@Entity
@Table(name="VarianteAchetee")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class VarianteAchetee {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float qte;

    @Column(nullable = false)
    private float pu;

    @ManyToOne()
    private FactureAchat factureAchat;

}
