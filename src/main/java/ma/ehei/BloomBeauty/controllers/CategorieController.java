package ma.ehei.BloomBeauty.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

import ma.ehei.BloomBeauty.DTO.RequestCategorie;
import ma.ehei.BloomBeauty.entity.Categorie;

import ma.ehei.BloomBeauty.repository.CategorieRepository;

import ma.ehei.BloomBeauty.services.CategorieServices;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Categorie")
@AllArgsConstructor
public class CategorieController {

    @Autowired
    private final CategorieServices categorieService;

    @GetMapping("/getAllCategories")
    public List<Categorie> getAllCategories() {
        return categorieService.read();
    }

    @GetMapping("/getCategorieById/{id}")
    public Categorie getCategorieById(@PathVariable(value = "id") Long categorieId) {
        return categorieService.getCategorieById(categorieId);
    }

    @PostMapping(value = "/createCategorie", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Categorie createCategorie(@ModelAttribute Categorie categorie, @RequestParam MultipartFile file,HttpServletRequest request) throws IOException {
        // Save the image to the images folder
        File folder = new File("images");
        if (!folder.exists()) {folder.mkdirs();}
        String path=folder.getAbsolutePath();
        Path filePath = Paths.get(folder + File.separator + file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        Path imgPath=filePath.resolve(filePath).normalize();
        Resource resourceImage = new UrlResource(imgPath.toUri());
        String contentType = request.getServletContext().getMimeType(resourceImage.getFile().getAbsolutePath());

        //RequestCategorie rc=(new ObjectMapper()).readValue(categorie, RequestCategorie.class);
        /*// Set the image URL in the Categorie object
        String imageUrl = "http://localhost:8080/images/" + fileName;
        categorie.setImageUrl(imageUrl);
        // Save the Categorie object to the database*/
        String imageName = resourceImage.getFilename();
        categorie.setImageUrl(imageName);
        return categorieService.create(categorie);
        //return new Categorie();
    }
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws MalformedURLException {
// Load file as Resource
        File file = new File("images/" + fileName);
        Resource resource = new UrlResource(file.toURI());
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }

// Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    /*@PostMapping("/addC")
    public String saveProduct(@RequestParam("file") MultipartFile file,
                              @RequestParam("nameFr") String name,
                              @RequestParam("parent") int parent,
                              @RequestParam("description") String desc,
                              @RequestParam("priorite") int priorite,
                              @RequestParam("icon") String icon
                              )
    {
        categorieService.saveToDB(file,name, desc, parent,priorite, icon);
        return "Ajout avec succes";
    }
*/
    /*@PutMapping("/updateCategorie/{id}")
    public Categorie updateCategorie(@PathVariable(value = "id") Long categorieId, @RequestBody Categorie categorieDetails) {
        return categorieService.update(categorieId, categorieDetails);
    }*/

    @PutMapping(value = "/updateCategorie/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "id") Long categorieId,
                                                     @ModelAttribute Categorie categorie,
                                                     @RequestParam(required = false) MultipartFile file) throws IOException {
        Categorie existingCategorie = categorieService.getCategorieById(categorieId);
        if (existingCategorie == null) {
            throw new ResourceNotFoundException("Categorie not found with id " + categorieId);
        }

        // Update fields
        existingCategorie.setNameFr(categorie.getNameFr());
        existingCategorie.setDescription(categorie.getDescription());
        existingCategorie.setParent(categorie.getParent());
        existingCategorie.setPriorite(categorie.getPriorite());

        // Update image if provided
        if (file != null && !file.isEmpty()) {
            File folder = new File("images");
            if (!folder.exists()) {folder.mkdirs();}
            Path filePath = Paths.get(folder + File.separator + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            Path imgPath=filePath.resolve(filePath).normalize();
            Resource resourceImage = new UrlResource(imgPath.toUri());
            String imageName = resourceImage.getFilename();
            existingCategorie.setImageUrl(imageName);
        }

        Categorie updatedCategorie = categorieService.update(existingCategorie.getId(), existingCategorie);
        return ResponseEntity.ok(updatedCategorie);
    }


    @DeleteMapping("/deleteCategorie/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable(value = "id") Long categorieId) {
        categorieService.delete(categorieId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Categorie>> searchVilles(@RequestParam("q") String keyword) {
        List<Categorie> villes = categorieService.findByKeyword(keyword);
        return new ResponseEntity<>(villes, HttpStatus.OK);
    }


}



