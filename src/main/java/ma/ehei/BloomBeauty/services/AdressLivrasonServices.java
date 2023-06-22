package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.AdressLivrason;

import java.util.List;

public interface AdressLivrasonServices {
    AdressLivrason create (AdressLivrason adressLivrason);
    List<AdressLivrason> read();
    AdressLivrason update (Long id,AdressLivrason adressLivrason);
    String delete(Long id);
}
