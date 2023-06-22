package ma.ehei.BloomBeauty.services;

import ma.ehei.BloomBeauty.entity.OffresVariante;

import java.util.List;

public interface OffresVarianteServices {


    OffresVariante create (OffresVariante  offresVariante);
    List<OffresVariante > read();
    OffresVariante  update (Long id, OffresVariante   offresVariante);
    String delete(Long id);
}
