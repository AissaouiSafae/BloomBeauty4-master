package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="PanierTemporaire")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierTemporaire {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "Utilisateur")
    private Utilisateur utilisateur;

    //etat ?? champs ou bien la table


}
