package ma.ehei.BloomBeauty.controllers.Auth;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.DTO.User;
import ma.ehei.BloomBeauty.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/demo/List")
public class demoController {
    private final UserRepository userRepository;
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
