package com.poly.shoptrangsuc.Jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "ppeppppppppppppppppppppppppppppppppppppppppppppejdjjdjdjjjdjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjhdhhpdpdpdpdpdpdppdpdpd"; // Thay bằng secret key của bạn
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 giờ

    public static String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static boolean validateToken(String token, String subject) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject().equals(subject) && !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
