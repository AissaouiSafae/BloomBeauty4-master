package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="RoleRoute")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "routes_id")
    private Routes routes;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Roles roles;





}