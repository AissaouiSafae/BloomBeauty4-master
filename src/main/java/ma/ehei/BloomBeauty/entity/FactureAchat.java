package ma.ehei.BloomBeauty.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Entity
@Table(name="FactureAchat")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FactureAchat {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float total;

    @Column(nullable = false)
    private String totalLettre;

    @Column(nullable = false)
    private Date dateCreation;

    @OneToMany(mappedBy = "factureAchat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name="factureAchat")
    private List<VarianteAchetee> varianteAchetees;



    @ManyToOne()
    @JoinColumn(name = "Fournisseur")
    private Fournisseur fournisseur;





}
