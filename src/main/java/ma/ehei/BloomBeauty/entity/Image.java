package ma.ehei.BloomBeauty.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String alt;

    /*@Column(nullable = false)
    private int priorite;*/

    @ManyToOne
    @JoinColumn(name = "variante")
    @JsonIgnoreProperties("images")
   // @JsonBackReference
   // @JsonIgnore // Ignorer la sérialisation de cette propriété lors de la sérialisation de Variante
    // Ignore la sérialisation de cette propriété lors de la sérialisation de Variante
    private Variante variante;






}
