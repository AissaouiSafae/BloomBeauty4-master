package ma.ehei.BloomBeauty.services;


import ma.ehei.BloomBeauty.entity.Image;
import ma.ehei.BloomBeauty.entity.Produit;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ImageServices {

    Image create (Image image) throws ChangeSetPersister.NotFoundException;
    List<Image> read();
    Image update (Long id, Image  image) throws ChangeSetPersister.NotFoundException;
    String delete(Long id);
    Image getImageById(Long id);
}
