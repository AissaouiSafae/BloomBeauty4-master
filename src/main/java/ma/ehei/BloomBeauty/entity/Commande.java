package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Commande")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private int total;

    @Column(nullable = false)
    private Date dateCreation;

    @Column(nullable = false)
    private Date dateValidation;




    @ManyToOne()
    @JoinColumn(name = "UtilisateurId")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<varianteCommande> varianteCommandes;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EtatCmd> etatCmds;





}

