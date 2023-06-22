package ma.ehei.BloomBeauty.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCategorie {
    private String nameFr;
    private  int priorite;
    private  int parent;
   private String description;
   private  MultipartFile file;
}
