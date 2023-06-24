package ma.ehei.BloomBeauty.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehei.BloomBeauty.DTO.User;


import java.util.List;
import java.util.Set;

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
    private String nomfr;

    @Column(nullable = false)
    private int priorite;


/*
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Role_Route",
            joinColumns = { @JoinColumn(name = "RoleId") },
            inverseJoinColumns = { @JoinColumn(name = "RouteId") }
    )
    private List<Routes> routes;

*/



    @OneToMany(mappedBy = "roles", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("roles")
    private List<RoleRoute> roleRoutes;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateurs;
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;



}
