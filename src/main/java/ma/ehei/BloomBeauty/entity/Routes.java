package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehei.BloomBeauty.entity.RoleRoute;


import java.util.List;

@Entity
@Table(name="Routes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Routes {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String RouteKey;

    @Column(length = 50)
    private String titre;


    @Column(nullable = false)
    private  int  priorite;


    @OneToMany(mappedBy = "routes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoleRoute> roleRoutes;

}
