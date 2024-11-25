package com.poly.shoptrangsuc.Service;

import com.poly.shoptrangsuc.DTO.JwtAuthenticationResponse;
import com.poly.shoptrangsuc.DTO.RefreshTokenRequest;
import com.poly.shoptrangsuc.DTO.SignUpRequest;
import com.poly.shoptrangsuc.DTO.SigninRequest;
import com.poly.shoptrangsuc.Model.Account;

public interface AuthenticationService {
    Account signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
