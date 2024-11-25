package com.poly.shoptrangsuc.Service;

import com.poly.shoptrangsuc.DTO.ProductDTO;
import com.poly.shoptrangsuc.Model.Product;
import com.poly.shoptrangsuc.Model.ProductDetails;
import com.poly.shoptrangsuc.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public ProductDTO getProductById(Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return convertToDTO(product.get());
        } else {
            // Handle the case where the product with the given ID is not found
            throw new RuntimeException("Product not found with ID: " + productId);
        }
    }
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescribe(product.getDescribe());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setDateAdded(product.getDateAdded());
        productDTO.setStatus(product.getStatus());

        if (product.getProductDetails() != null) {
            productDTO.setDetailProductId(product.getProductDetails().getDetailProductId());
            // Lấy thông tin hình ảnh từ ProductDetails
            if (product.getProductDetails() != null && product.getProductDetails().getImages() != null) {
                productDTO.setImageUrl(product.getProductDetails().getImages().getImageUrl());
            }

            if (product.getProductDetails().getMaterial() != null) {
                productDTO.setMaterialName(product.getProductDetails().getMaterial().getMaterialName());
            }
            if (product.getProductDetails().getSize() != null) {
                productDTO.setSizeDescription(product.getProductDetails().getSize().getSizeDescription());
            }
            if (product.getProductDetails().getProductCategory() != null) {
                productDTO.setCategoryName(product.getProductDetails().getProductCategory().getCategoryName());
            }
        }
        return productDTO;
    }

}