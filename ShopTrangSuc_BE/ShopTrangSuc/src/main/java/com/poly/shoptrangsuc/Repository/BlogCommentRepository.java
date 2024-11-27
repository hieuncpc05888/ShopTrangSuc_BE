package com.poly.shoptrangsuc.Repository;

import com.poly.shoptrangsuc.Model.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCommentRepository extends JpaRepository<BlogComment, Integer> {
}
