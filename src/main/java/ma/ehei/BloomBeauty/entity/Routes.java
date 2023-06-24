package ma.ehei.BloomBeauty.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehei.BloomBeauty.DTO.User;
import ma.ehei.BloomBeauty.entity.RoleRoute;
import org.hibernate.mapping.Set;


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

    @OneToMany(mappedBy = "routes", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("routes")
    private List<RoleRoute> roleRoutes;
    @ManyToOne
    @JoinColumn(name = "routes")
    @JsonIgnoreProperties("users")
    private User user;





    /*@ManyToMany(mappedBy = "Routes")
    private List<Roles> roles;
*/



}
