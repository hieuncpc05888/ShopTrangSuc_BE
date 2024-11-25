package com.poly.shoptrangsuc.Service.Impl;


import com.poly.shoptrangsuc.DTO.JwtAuthenticationResponse;
import com.poly.shoptrangsuc.DTO.RefreshTokenRequest;
import com.poly.shoptrangsuc.DTO.SignUpRequest;
import com.poly.shoptrangsuc.DTO.SigninRequest;
import com.poly.shoptrangsuc.Model.Account;
import com.poly.shoptrangsuc.Model.Role;
import com.poly.shoptrangsuc.Repository.AccountRepository;
import com.poly.shoptrangsuc.Service.AuthenticationService;
import com.poly.shoptrangsuc.Service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    public Account signup(SignUpRequest signUpRequest){
        Account account = new Account();

        account.setEmail(signUpRequest.getEmail());
        account.setFullname(signUpRequest.getFullname());
        account.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        account.setPhone(signUpRequest.getPhone());
        account.setGender(Boolean.valueOf(signUpRequest.getGender()));

        account.setRole(Role.USER);

        return accountRepository.save(account);
    }

    public JwtAuthenticationResponse signin(SigninRequest siginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(siginRequest.getEmail()
                , siginRequest.getPassword()));

        var account = accountRepository.findByEmail(siginRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Email not found"));
        var jwt = jwtService.generateToken(account);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), account);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        System.out.println("Account role: " + account.getRole()); // Debugging line
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        jwtAuthenticationResponse.setFullname(account.getFullname());
        jwtAuthenticationResponse.setRoles(List.of(account.getRole().name()));
        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String userEmail = jwtService.extractUsername(refreshTokenRequest.getToken());
        Account account = accountRepository.findByEmail(userEmail).orElseThrow(() -> new IllegalArgumentException("Email not found"));
        if (jwtService.isValidToken(refreshTokenRequest.getToken(), account)) {
            var jwt = jwtService.generateToken(account);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }

}
