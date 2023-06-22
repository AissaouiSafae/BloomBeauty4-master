package ma.ehei.BloomBeauty.controllers.Auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ma.ehei.BloomBeauty.securiter.Services.AuthenticationService;
import ma.ehei.BloomBeauty.utils.AuthenticationRequest;
import ma.ehei.BloomBeauty.utils.AuthenticationResponse;
import ma.ehei.BloomBeauty.utils.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    // client
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
    return ResponseEntity.ok(authenticationService.register(request));
    }
    // ajouter utilisateur
    @PostMapping("/registeradmin")
    public ResponseEntity<AuthenticationResponse> registeradmin(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.registerAdmin(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authenticationService.refreshToken(request,response);
    }
}
