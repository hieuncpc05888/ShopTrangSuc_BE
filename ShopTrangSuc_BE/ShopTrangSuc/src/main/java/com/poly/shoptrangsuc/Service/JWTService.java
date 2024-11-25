package com.poly.shoptrangsuc.Service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

// You can add this if you want to ensure it's recognized as a bean.
public interface JWTService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    boolean isValidToken(String token, UserDetails userDetails);
    String generateRefreshToken(Map<String,Object> extractClaims, UserDetails userDetails);
}