package com.poly.shoptrangsuc.DTO;

import lombok.Data;

import java.util.List;

@Data
public class JwtAuthenticationResponse {
    private String token;
    private String refreshToken;
    private String fullname;
    private List<String> roles; // Thêm trường roles

    // Thêm phương thức setRoles
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
