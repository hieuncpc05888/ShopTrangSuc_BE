package com.poly.shoptrangsuc.DTO;

import lombok.Data;

@Data
public class SignUpRequest {
    private String fullname;
    private String password;
    private String email;
    private String phone;
    private String gender;



}
