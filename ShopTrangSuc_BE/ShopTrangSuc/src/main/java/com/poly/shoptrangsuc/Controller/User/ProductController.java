package com.poly.shoptrangsuc.Controller.User;

import com.poly.shoptrangsuc.DTO.ProductDTO;
import com.poly.shoptrangsuc.Model.Images;
import com.poly.shoptrangsuc.Model.Product;
import com.poly.shoptrangsuc.Repository.ProductRepository;
import com.poly.shoptrangsuc.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/products")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }
    @GetMapping()
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{productId}")
    public ProductDTO getProductById(@PathVariable("productId") Integer productId) {
        return productService.getProductById(productId);
    }
}