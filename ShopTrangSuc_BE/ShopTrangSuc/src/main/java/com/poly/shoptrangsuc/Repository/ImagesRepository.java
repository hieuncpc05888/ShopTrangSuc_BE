package com.poly.shoptrangsuc.Repository;

import com.poly.shoptrangsuc.Model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImagesRepository extends JpaRepository<Images, Integer> {
    Optional<Images> findByImageUrl(String imageUrl);

}
