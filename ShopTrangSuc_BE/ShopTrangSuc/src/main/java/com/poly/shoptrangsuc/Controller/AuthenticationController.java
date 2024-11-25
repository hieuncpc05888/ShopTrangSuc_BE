package com.poly.shoptrangsuc.Controller;

import com.poly.shoptrangsuc.DTO.JwtAuthenticationResponse;
import com.poly.shoptrangsuc.DTO.RefreshTokenRequest;
import com.poly.shoptrangsuc.DTO.SignUpRequest;
import com.poly.shoptrangsuc.DTO.SigninRequest;
import com.poly.shoptrangsuc.Model.Account;
import com.poly.shoptrangsuc.Service.AuthenticationService;
import com.poly.shoptrangsuc.Service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final JWTService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Account> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
    @DeleteMapping("/logout")
    public ResponseEntity<HashMap<String, String>> logout(@RequestHeader("Authorization") String token) {
        // Invalidate the token here if needed (optional)
        // For example, you could maintain a blacklist of tokens or update a user session
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Logout successful");
        return ResponseEntity.ok(response);
    }
}
