package ma.ehei.BloomBeauty.securiter.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ma.ehei.BloomBeauty.DTO.User;
import ma.ehei.BloomBeauty.enumiration.ERole;
import ma.ehei.BloomBeauty.repository.UserRepository;
import ma.ehei.BloomBeauty.utils.AuthenticationRequest;
import ma.ehei.BloomBeauty.utils.AuthenticationResponse;
import ma.ehei.BloomBeauty.utils.RegisterRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .NomComplet(request.getNomComplet())
                .tel(request.getTel())
                .AdressPostal(request.getAdressPostal())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .ERole(ERole.CLIENT)
                //TODO MANUPILATION

                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        var user = User.builder()
                .NomComplet(request.getNomComplet())
                .tel(request.getTel())
                .AdressPostal(request.getAdressPostal())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .ERole(ERole.ADMIN)
                //TODO MANUPILATION

                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getTel(),
                        request.getPassword()));

        var user = userRepository.findByTel(request.getTel())
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if(authHeader == null || !authHeader.startsWith("Bearer")){
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUserName(refreshToken);
        if (userEmail != null) {
            var userDetails = this.userRepository.findByTel(userEmail)
                    .orElseThrow(()-> new UsernameNotFoundException("Tel Not Found"));

            if(jwtService.isTokenValid(refreshToken,userDetails)){
               var accessToken = jwtService.generateToken(userDetails);
               var authResponse = AuthenticationResponse.builder()
                       .accessToken(accessToken)
                       .refreshToken(refreshToken)
                       .build();
               new ObjectMapper().writeValue(response.getOutputStream() , authResponse);
            }
        }
    }
}
