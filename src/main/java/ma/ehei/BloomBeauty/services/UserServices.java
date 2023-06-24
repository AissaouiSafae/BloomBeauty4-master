package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.DTO.User;
import ma.ehei.BloomBeauty.entity.Utilisateur;

import java.util.List;

public interface UserServices {
    User create (User utilisateur);
    List<User > read ();
    User  update (Long id, User utilisateur);
    String delete(Long id);
    User findByLoginAndPassword(String login, String password);
}
