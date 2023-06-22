package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="OffresVariante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OffresVariante {

    @jakarta.persistence.Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "RoutesId")
    private Offres offres;
    @ManyToOne()
    @JoinColumn(name = "RolesId")
    private Variante variante;
}
