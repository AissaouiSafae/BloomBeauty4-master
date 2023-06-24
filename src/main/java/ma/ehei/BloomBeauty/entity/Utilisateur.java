package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehei.BloomBeauty.entity.AdressLivrason;
import ma.ehei.BloomBeauty.entity.Commande;


import java.util.List;

@Entity
@Table(name="Utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String NomComplet;

    @Column(nullable = false)
    private String tel;

    @Column(nullable = false)
    private String adressPostal;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String passWord;

    @Column(nullable = false)
    private String login;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Commande> commandes;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdressLivrason> adressLivrasons;

    @ManyToOne
    @JoinColumn(name = "RolesId")
    private Roles roles;




}

