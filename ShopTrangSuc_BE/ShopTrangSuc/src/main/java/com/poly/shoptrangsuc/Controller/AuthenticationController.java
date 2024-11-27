package com.poly.shoptrangsuc.Controller;

import com.poly.shoptrangsuc.DTO.JwtAuthenticationResponse;
import com.poly.shoptrangsuc.DTO.RefreshTokenRequest;
import com.poly.shoptrangsuc.DTO.SignUpRequest;
import com.poly.shoptrangsuc.DTO.SigninRequest;
import com.poly.shoptrangsuc.Jwt.JwtUtil;
import com.poly.shoptrangsuc.Model.Account;
import com.poly.shoptrangsuc.Repository.AccountRepository;
import com.poly.shoptrangsuc.Service.AuthenticationService;
import com.poly.shoptrangsuc.Service.EmailService;
import com.poly.shoptrangsuc.Service.Impl.AccountServeImpl;
import com.poly.shoptrangsuc.Service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final JWTService jwtService;
    private final AuthenticationService authenticationService;
    private final AccountServeImpl accountServeImpl;
    private final EmailService emailService;
    private final AccountRepository accountRepository;

    // Register new account
    @PostMapping("/register")
    public ResponseEntity<Account> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    // Login and return JWT token
    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest) {

        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    // Refresh token ô gọi controller nào
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

    // Logout
    @DeleteMapping("/logout")
    public ResponseEntity<HashMap<String, String>> logout(@RequestHeader("Authorization") String token) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Logout successful");
        return ResponseEntity.ok(response);
    }

    // Forgot password: Send reset link to email
    @PostMapping("/forgotpassword")
    public String forgotPassword(@RequestParam String email) {
        email = email.trim().toLowerCase(); // Normalize email
        Optional<Account> accountOptional = accountServeImpl.findByEmail(email);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();

            // Generate reset token
            String resetToken = JwtUtil.generateToken(account.getEmail());

            // Build the reset link
            String resetLink = "http://localhost:3000/resetpassword/" + account.getAccountId()+ "/" + resetToken ;

            // Send email
            emailService.sendEmail(email, "Đặt lại mật khẩu", "Click vào link để đặt lại mật khẩu: " + resetLink);
            return "Email reset password đã được gửi.";
        } else {
            return "Không tìm thấy người dùng với email này.";
        }
    }

    // Reset password using token cái vconroler này ko phải
    @PostMapping("/resetpassword/{id}/{token}")
    public ResponseEntity<String> resetPassword(@PathVariable Long id, @PathVariable String token, @RequestBody String newPassword) {
        // Kiểm tra tài khoản
        Optional<Account> accountOptional = accountServeImpl.findById(id);
        if (accountOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Không tìm thấy người dùng.");
        }
//ở đâu
        Account account = accountOptional.get();
        System.out.println(token);
        // Kiểm tra token
        if (!JwtUtil.validateToken(token, account.getEmail())) {
            return ResponseEntity.status(403).body("Token không hợp lệ hoặc đã hết hạn.");
        }

        // Mã hóa mật khẩu mới
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);

        // Cập nhật mật khẩu đã được mã hóa
        account.setPassword(encodedPassword);
        accountRepository.save(account); // Lưu tài khoản với mật khẩu mới đã mã hóa ô vô cái controller đi rồi coi ch

        return ResponseEntity.ok("Mật khẩu đã được thay đổi thành công.");
    }

}
