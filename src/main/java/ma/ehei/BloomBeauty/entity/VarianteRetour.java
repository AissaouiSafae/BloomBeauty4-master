package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="VarianteRetour")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VarianteRetour {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float qteRetourner;

    @Column(nullable = false)
    private String commentaire;


    @ManyToOne()
    @JoinColumn(name = "retour_id")
    private Retour retour;



}
