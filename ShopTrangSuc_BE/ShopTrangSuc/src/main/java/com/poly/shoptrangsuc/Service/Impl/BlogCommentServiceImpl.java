package com.poly.shoptrangsuc.Service.Impl;

import com.poly.shoptrangsuc.Model.BlogComment;
import com.poly.shoptrangsuc.Repository.BlogCommentRepository;
import com.poly.shoptrangsuc.Service.BlogCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogCommentServiceImpl implements BlogCommentService {
    private final BlogCommentRepository blogCommentRepository;

    @Override
    public BlogComment save(BlogComment comment) {
        return blogCommentRepository.save(comment);
    }
}
