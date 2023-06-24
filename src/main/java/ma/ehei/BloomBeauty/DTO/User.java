package ma.ehei.BloomBeauty.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehei.BloomBeauty.entity.RoleRoute;
import ma.ehei.BloomBeauty.entity.Roles;
import ma.ehei.BloomBeauty.entity.Routes;
import ma.ehei.BloomBeauty.enumiration.ERole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.RouteMatcher;

import java.util.Collection;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "users")
// La classe User : implémente l'interface UserDetails fournie par Spring Security,
// ce qui signifie qu'elle peut être utilisée pour l'authentification et l'autorisation des utilisateurs.

public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NomComplet;
    private String tel;

    private String email ;



    @OneToMany(mappedBy = "users", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("users")
    private List<Routes> routes;
    @OneToOne(mappedBy = "users")
    private Roles role;





    //Le mot de passe est annoté avec @JsonIgnore pour éviter de le renvoyer lors de la sérialisation JSON.
    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private ERole ERole;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(ERole.name()));
    }

    @Override
    public String getUsername() {
        return tel;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
