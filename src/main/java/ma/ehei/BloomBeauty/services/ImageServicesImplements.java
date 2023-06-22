package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Image;
import ma.ehei.BloomBeauty.entity.Variante;
import ma.ehei.BloomBeauty.repository.ImageRepository;
import ma.ehei.BloomBeauty.repository.VarianteRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ImageServicesImplements implements ImageServices{

    public final ImageRepository imageRepository;
    @Override
    public Image create(Image image) throws ChangeSetPersister.NotFoundException {
        return imageRepository.save(image);

    }

    @Override
    public List<Image> read() {
        return imageRepository.findAll();
    }
    @Override
    public Image getImageById(Long id) {
        Optional<Image> image = imageRepository.findById(id);
        return image.orElseThrow(() -> new RuntimeException("image introuvable"));
    }

    @Override
    public Image update(Long id, Image image) throws ChangeSetPersister.NotFoundException {
        /*Variante variante = varianteRepository.findById(image.getVariante().getId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());*/
       // Variante variante = image.getVariante();
        Optional<Image> existingImage = imageRepository.findById(id);
        if (existingImage.isPresent()) {
            Image updatedImage = existingImage.get();
            updatedImage.setAlt(image.getAlt());
            if (!StringUtils.isEmpty(image.getImage())) {
                updatedImage.setImage(image.getImage());
            }
            updatedImage.setVariante(image.getVariante());
           /* if (variante != null) {
                String alt = variante.getNameFr();
                image.setAlt(alt);
            }*/
            return imageRepository.save(updatedImage);
        } else {
            throw new RuntimeException("image introuvable");
        }
    }

    @Override
    public String delete(Long id) {
        imageRepository.deleteById(id);
        return "bien supprimer ";
    }
}
