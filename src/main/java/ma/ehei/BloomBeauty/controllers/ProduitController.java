package ma.ehei.BloomBeauty.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Categorie;
import ma.ehei.BloomBeauty.entity.Fournisseur;
import ma.ehei.BloomBeauty.entity.Produit;
import ma.ehei.BloomBeauty.services.ProduitServices;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProduitController {

    @Autowired
    public final ProduitServices productService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Produit>> getAllProducts() {
        return ResponseEntity.ok(productService.findAllWithCategoriesAndAttributes());
    }


    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Produit> getProductById(@PathVariable Long id) {
        Produit product = productService.getProductById(id);
        return new ResponseEntity<Produit>(product, HttpStatus.OK);
    }

    @PostMapping(value ="/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Produit create(@ModelAttribute Produit product, @RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
        File folder = new File("images/Produits");
        if (!folder.exists()) {folder.mkdirs();}
        String path=folder.getAbsolutePath();
        Path filePath = Paths.get(folder + File.separator + file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        Path imgPath=filePath.resolve(filePath).normalize();
        Resource resourceImage = new UrlResource(imgPath.toUri());
        String contentType = request.getServletContext().getMimeType(resourceImage.getFile().getAbsolutePath());
        String imageName = resourceImage.getFilename();
        product.setImageUrl(imageName);
        return productService.create(product);
    }
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws MalformedURLException {
// Load file as Resource
        File file = new File("images/Produits/" + fileName);
        Resource resource = new UrlResource(file.toURI());
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PutMapping(value = "/updateProduit/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Produit> updateProduct(@PathVariable(value = "id") Long id, @ModelAttribute Produit product,@RequestParam(required = false) MultipartFile file) throws IOException {
        Produit existingProduit = productService.getProductById(id);
        if (existingProduit == null) {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
        existingProduit.setNameFr(product.getNameFr());
        existingProduit.setDescription(product.getDescription());
        existingProduit.setSlug(product.getSlug());
        existingProduit.setAttribut(product.getAttribut());
        existingProduit.setCategorie(product.getCategorie());
        if (file != null && !file.isEmpty()) {
            File folder = new File("images");
            if (!folder.exists()) {folder.mkdirs();}
            Path filePath = Paths.get(folder + File.separator + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            Path imgPath=filePath.resolve(filePath).normalize();
            Resource resourceImage = new UrlResource(imgPath.toUri());
            String imageName = resourceImage.getFilename();
            existingProduit.setImageUrl(imageName);
        }
        Produit updatedProduct = productService.update(existingProduit.getId(), existingProduit);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return productService.delete(id);
    }
    @GetMapping("/getProductSlugById/{id}")
    public ResponseEntity<String> getProductSlugById(@PathVariable Long id) {
        Produit product = productService.getProductById(id);
        String slug = product.getSlug();
        product.setSlug(product.getSlug());
        return new ResponseEntity<String>(slug, HttpStatus.OK);
    }
    @GetMapping("/search")
    ResponseEntity<List<Produit>> rechercherProduitParMotCle(@RequestParam("keyword") String keyword) {
        List<Produit> produits = productService.findByKeyword(keyword);
        return ResponseEntity.ok(produits);
    }


}










