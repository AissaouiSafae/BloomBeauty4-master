package ma.ehei.BloomBeauty.controllers;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.DTO.User;
import ma.ehei.BloomBeauty.entity.Utilisateur;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@AllArgsConstructor
public class UserControllet {
    private final ma.ehei.BloomBeauty.services.UserServices UserServices;

    @PostMapping("/create")
    public User create(@RequestBody User User) {
        return UserServices.create(User);
    }

    @GetMapping("/read")
    public List<User> read() {
        return UserServices.read();
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User utilisateur) {
        return UserServices.update(id, utilisateur);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return UserServices.delete(id);
    }
}

