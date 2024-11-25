package com.poly.shoptrangsuc.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer productId;
    private String productName;
    private BigDecimal price;
    private String describe;
    private Integer quantity;
    private LocalDate dateAdded;
    private String status;

    // Nested ProductDetails information
    private Integer detailProductId;
    private String materialName;
    private Integer sizeDescription;
    private String categoryName;
    private String imageUrl;
}
