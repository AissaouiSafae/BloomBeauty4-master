package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name="Roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Nomfr;

    @Column(nullable = false)
    private int priorite;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateurs;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoleRoute> roleRoutes;

}
