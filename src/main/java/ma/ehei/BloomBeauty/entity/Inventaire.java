package ma.ehei.BloomBeauty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Table(name="Inventaire")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventaire {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float qte;

    @Column(nullable = false)
    private Date Date;

    @Column(length = 150)
    private String description;



}