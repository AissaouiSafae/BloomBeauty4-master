package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="AdressLivrason")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdressLivrason {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    private String Nom;

    @Column(nullable = false)
    private String Prenom;

    @Column(nullable = false)
    private int tel;


    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int codePostal;

    @Column(nullable = false)
    private String adressPostal;

    @Column(nullable = false)
    private int Ville;

    @ManyToOne()
    @JoinColumn(name = "UtilisateurId")
    private Utilisateur utilisateur;
}