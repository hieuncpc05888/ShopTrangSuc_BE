package com.poly.shoptrangsuc.Repository;


import com.poly.shoptrangsuc.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductDetails_DetailProductId(Integer detailProductId);
}
