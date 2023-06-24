package ma.ehei.BloomBeauty.config;

import lombok.RequiredArgsConstructor;
import ma.ehei.BloomBeauty.enumiration.ERole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collection;
import java.util.function.Supplier;

import static org.springframework.security.authorization.AuthorizationDecision.*;
@Configuration
@EnableWebSecurity // pour activer la configuration de sécurité basée sur le web
@RequiredArgsConstructor
public class SecurityConfiguration {
    // La classe prend en compte deux dépendances via le constructeur : authenticationProvider et jwtAuthFilter. Ces dépendances sont injectées à l'aide de l'annotation @RequiredArgsConstructor.
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthFiler;
    // la protection CSRF fournis par Spring  (Cross-Site Request Forgery) est désactivée avec l'appel à .csrf().disable()
// les règles d'autorisation: authorizeHttpRequests(). Dans cet exemple, la règle permitAll() est utilisée pour autoriser les requêtes vers les URL commençant par "/api/v1/auth/**" sans authentification. Cela signifie que ces URL sont accessibles publiquement sans avoir besoin d'être connecté.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**"
                )
                .permitAll()
                .requestMatchers(request -> {

                    return request.getRequestURI().equals("/Attribut/getAllAttributs") &&
                            request.getMethod().equals("GET");
                }).access(this::isUserInRole)

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFiler , UsernamePasswordAuthenticationFilter.class);
        System.out.println("Hello");
        return http.build();
    }



    private AuthorizationDecision isUserInRole(Supplier<Authentication> authenticationSupplier, RequestAuthorizationContext requestAuthorizationContext) {
        Authentication authentication = authenticationSupplier.get();
        Collection<? extends SimpleGrantedAuthority> authorities = (Collection<? extends SimpleGrantedAuthority>) authentication.getAuthorities();
        for (ERole role : ERole.values()) {
            if (authorities.contains(new SimpleGrantedAuthority(role.name()))) {
                if (role == ERole.ADMIN) {
                    return new AuthorizationDecision(true);
                }
            }
        }
        return new AuthorizationDecision(false);
    }


}