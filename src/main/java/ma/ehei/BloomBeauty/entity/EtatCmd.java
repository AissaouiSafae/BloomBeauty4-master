package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehei.BloomBeauty.entity.Commande;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="EtatCmd")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtatCmd {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "Commande")
    private Commande commande;



}
