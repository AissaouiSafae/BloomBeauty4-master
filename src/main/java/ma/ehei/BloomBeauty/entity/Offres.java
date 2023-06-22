package ma.ehei.BloomBeauty.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Offres")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Offres {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private String titre;


    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String lien;


    @Column(length = 200)
    private String description;

    @Column(nullable = false)
    private Date DateDebut;

    @Column(nullable = false)
    private Date DateFin;


    @Column(nullable = false)
    private Date DateCreation;




}