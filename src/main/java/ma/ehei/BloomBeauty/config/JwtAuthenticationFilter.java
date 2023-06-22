package ma.ehei.BloomBeauty.config;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ma.ehei.BloomBeauty.securiter.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
//  but principal de la classe JwtAuthenticationFilter est de fournir un mécanisme d'authentification basé sur les jetons JWT
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;


// Le filtre est exécuté avant chaque requête entrante grâce à l'implémentation de la méthode doFilterInternal

    @Override
    protected void doFilterInternal(
            // Si l'en-tête "Authorization" est manquant ou ne commence pas par "Bearer",
            // cela signifie que le jeton JWT n'est pas présent ou n'est pas valide.
            // Dans ce cas, le filtre passe la requête au filtre suivant dans la chaîne de filtrage à l'aide de
            // filterChain.doFilter(request, response)
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
            final String authHeader = request.getHeader("Authorization");
            final String jwt;
            final String userEmail;
            if(authHeader == null || !authHeader.startsWith("Bearer")){
                filterChain.doFilter(request,response);
                return;
            }
        //Si le jeton JWT est présent et valide,
        // le filtre extrait l'adresse e-mail de l'utilisateur à partir du jeton en utilisant le service
        // jwtService.extractUserName(jwt)
            jwt = authHeader.substring(7);
            userEmail = jwtService.extractUserName(jwt);
            // l vérifie si l'authentification n'a pas encore été effectuée pour cette requête
        //
        // en utilisant SecurityContextHolder.getContext().getAuthentication() == null.
        // Si une authentification a déjà été effectuée (par exemple, si l'utilisateur est déjà connecté),
        // le filtre passe la requête au filtre suivant.
        // Si l'adresse e-mail de l'utilisateur est valide et l'authentification n'a pas encore été effectuée, le filtre utilise le userDetailsService pour charger les détails de l'utilisateur correspondant à l'adresse e-mail.

        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            if(jwtService.isTokenValid(jwt,userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
//Si le jeton est valide, le filtre crée un objet UsernamePasswordAuthenticationToken contenant les détails de l'utilisateur chargés précédemment et le définit dans le SecurityContextHolder. Cela indique que l'utilisateur est authentifié pour la requête actuelle.
//
//Enfin, le filtre passe la requête au filtre suivant dans la chaîne de filtrage en utilisant filterChain.doFilter(request, response).
//
//En résumé, la classe JwtAuthenticationFilter gère l'authentification basée sur les jetons JWT. Elle extrait le jeton de l'en-tête de la requête, vérifie son validité, charge les détails de l'utilisateur correspondant à partir du userDetailsService, et configure l'authentification dans le SecurityContextHolder pour les requêtes authentifiées ultérieures.

