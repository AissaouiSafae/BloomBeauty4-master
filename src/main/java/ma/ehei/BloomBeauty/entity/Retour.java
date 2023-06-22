package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Retour")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Retour {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;
    //test
    @OneToMany(mappedBy = "retour", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VarianteRetour> varianteRetours;

}


