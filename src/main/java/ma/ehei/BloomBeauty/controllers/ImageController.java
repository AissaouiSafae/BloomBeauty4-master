package ma.ehei.BloomBeauty.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;


import ma.ehei.BloomBeauty.entity.Image;
import ma.ehei.BloomBeauty.entity.Variante;
import ma.ehei.BloomBeauty.repository.ImageRepository;
import ma.ehei.BloomBeauty.repository.VarianteRepository;
import ma.ehei.BloomBeauty.services.ImageServices;
import ma.ehei.BloomBeauty.services.VarianteServices;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Image")
@AllArgsConstructor
public class ImageController {
    private final ImageServices imageServices;

    @GetMapping("/read")
    public List<Image> read() {
        return imageServices.read();
    }
    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  Image create(@ModelAttribute Image image, @RequestParam MultipartFile file, HttpServletRequest request) throws IOException, ChangeSetPersister.NotFoundException {
        // Variante variante = image.getVariante();
        File folder = new File("images/ImagesVariante");
        if (!folder.exists()) {folder.mkdirs();}
        String path=folder.getAbsolutePath();
        Path filePath = Paths.get(folder + File.separator + file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        Path imgPath=filePath.resolve(filePath).normalize();
        Resource resourceImage = new UrlResource(imgPath.toUri());
        String contentType = request.getServletContext().getMimeType(resourceImage.getFile().getAbsolutePath());
        String imageName = resourceImage.getFilename();
        image.setImage(imageName);
        return imageServices.create(image);
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

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return imageServices.delete(id);

    }
    @GetMapping("/getImageById/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        Image image = imageServices.getImageById(id);
        return new ResponseEntity<Image>(image, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Image> update(@PathVariable(value = "id") Long id, @ModelAttribute Image image,@RequestParam(required = false) MultipartFile file) throws IOException, ChangeSetPersister.NotFoundException {
        /*Variante variante = varianteServices.getVarianteById(image.getVariante().getId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());*/
        Image existingImage = imageServices.getImageById(id);
        if (existingImage == null) {
            throw new ResourceNotFoundException("Image not found with id " + id);
        }

        existingImage.setAlt(image.getAlt());
        existingImage.setVariante(image.getVariante());
        if (file != null && !file.isEmpty()) {
            File folder = new File("images/ImagesVariante");
            if (!folder.exists()) {folder.mkdirs();}
            Path filePath = Paths.get(folder + File.separator + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            Path imgPath=filePath.resolve(filePath).normalize();
            Resource resourceImage = new UrlResource(imgPath.toUri());
            String imageName = resourceImage.getFilename();
            existingImage.setImage(imageName);
        }
        Image updatedImage = imageServices.update(existingImage.getId(), existingImage);
        return ResponseEntity.ok(updatedImage);
    }


}
