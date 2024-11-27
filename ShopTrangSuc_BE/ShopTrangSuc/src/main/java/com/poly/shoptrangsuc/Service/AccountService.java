package com.poly.shoptrangsuc.Service;

import com.poly.shoptrangsuc.Model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface AccountService {
    // Tìm người dùng theo email
    Optional<Account> findByEmail(String email);

    // Tìm người dùng theo ID
    Optional<Account> findById(Long id);

    // Cập nhật mật khẩu cho người dùng
    void updatePassword(Account account, String newPassword);

    // Dịch vụ UserDetails
    UserDetailsService userDetailsService();
}
