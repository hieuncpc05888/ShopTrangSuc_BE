package com.poly.shoptrangsuc.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "describe")
    private String describe;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "date_added")
    private LocalDate dateAdded;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "detail_product_id") // Update the column name here
    private ProductDetails productDetails;
}