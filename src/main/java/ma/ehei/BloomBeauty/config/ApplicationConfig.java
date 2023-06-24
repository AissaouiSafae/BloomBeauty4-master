package ma.ehei.BloomBeauty.config;

import lombok.RequiredArgsConstructor;
import ma.ehei.BloomBeauty.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
// Cette classe  contient plusieurs beans de configuration pour la sécurité de l'application
public class ApplicationConfig {

    private final UserRepository userRepository;
    // userDetailsService récupère les détails de l'utilisateur à partir du UserRepository
    // en utilisant l'adresse e-mail comme identifiant.
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepository.findByTel(username)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
    //  authenticationProvider utilise le userDetailsService
    //
    //  pour fournir les informations d'authentification à Spring Security.
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    //authenticationManager renvoie l'instance d'AuthenticationManager à utiliser dans l'application.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return  config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
