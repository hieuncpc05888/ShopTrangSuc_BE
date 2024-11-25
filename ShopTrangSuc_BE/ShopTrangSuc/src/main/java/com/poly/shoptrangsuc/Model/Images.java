package com.poly.shoptrangsuc.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Images")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "describe", length = 255)
    private String describe;

//    @ManyToOne
//    @JoinColumn(name = "detailproduct_id")
//    private ProductDetails productDetails;
}