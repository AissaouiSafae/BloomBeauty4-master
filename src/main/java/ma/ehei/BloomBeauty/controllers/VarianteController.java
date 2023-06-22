package ma.ehei.BloomBeauty.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Fournisseur;
import ma.ehei.BloomBeauty.entity.Image;
import ma.ehei.BloomBeauty.entity.Variante;
import ma.ehei.BloomBeauty.entity.Ville;
import ma.ehei.BloomBeauty.services.VarianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Variantes")
@AllArgsConstructor
public class VarianteController {

    @Autowired
    private final VarianteServices varianteServices;

    @GetMapping("/getAllVariantes")
    public ResponseEntity<List<Variante>> getAllVariantes() {
        List<Variante> variantes = varianteServices.read();
        return new ResponseEntity<>(variantes, HttpStatus.OK);
    }

    @GetMapping("/getVarianteById/{id}")
    public ResponseEntity<Variante> getVarianteById(@PathVariable Long id) {
        Optional<Variante> variante = varianteServices.getVarianteById(id);
        if (variante.isPresent()) {
            return ResponseEntity.ok(variante.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Variante create(@ModelAttribute Variante variante, @RequestParam List<MultipartFile> files, HttpServletRequest request) throws IOException {
        // Créez une liste pour stocker les entités d'Image
        List<Image> images = new ArrayList<>();
        File folder = new File("images/ImagesVariante");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String path = folder.getAbsolutePath();

        for (MultipartFile file : files) {
            Path filePath = Paths.get(folder + File.separator + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            Path imgPath = filePath.resolve(filePath).normalize();
            Resource resourceImage = new UrlResource(imgPath.toUri());
            String contentType = request.getServletContext().getMimeType(resourceImage.getFile().getAbsolutePath());

            String imageName = resourceImage.getFilename();

            // Créez une entité Image et définissez le nom de l'image
            Image image = new Image();
            image.setImage(imageName);

            // Associez l'image à la variante
            image.setVariante(variante);

            // Ajoutez l'entité Image à la liste
            images.add(image);
        }

        // Associez la liste d'images à la variante
        variante.setImages(images);

        // Enregistrez la variante avec les images associées en utilisant votre service approprié
        return varianteServices.create(variante);
    }
*/

    @PostMapping("/create")
    public Variante create(@RequestBody Variante variante) {
        return varianteServices.create(variante);
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
        // Load file as Resource
        File folder = new File("images/ImagesVariante");
        File file = new File(folder, fileName);
        Resource resource = new UrlResource(file.toURI());

        // Try to determine file's content type
        String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }



    @PutMapping("/updateVariante/{id}")
    public ResponseEntity<Variante> updateVariante(@PathVariable Long id, @RequestBody Variante variante) {
        Optional<Variante> existingVariante = varianteServices.getVarianteById(id);
        if (existingVariante.isPresent()) {
            variante.setId(id);
            Variante savedVariante = varianteServices.create(variante);
            return ResponseEntity.ok(savedVariante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Variante> existingVariante = varianteServices.getVarianteById(id);
        if (existingVariante.isPresent()) {
            varianteServices.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
