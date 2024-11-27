package com.poly.shoptrangsuc.Service.Impl;

import com.poly.shoptrangsuc.Model.Account;
import com.poly.shoptrangsuc.Repository.AccountRepository;
import com.poly.shoptrangsuc.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServeImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Optional<Account> findByEmail(String email) {
        // Trả về tài khoản tìm được từ cơ sở dữ liệu
        return accountRepository.findByEmail(email);
    }

    @Override
    public Optional<Account> findById(Long id) {
        // Trả về tài khoản tìm được từ cơ sở dữ liệu
        return accountRepository.findById(id);
    }

    @Override
    @Transactional
    public void updatePassword(Account account, String newPassword) {
        // Cập nhật mật khẩu mới cho tài khoản
        account.setPassword(newPassword);
        accountRepository.save(account); // Lưu lại thay đổi vào cơ sở dữ liệu
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                // Tìm tài khoản từ email
                Account account = accountRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

                // Trả về UserDetails từ tài khoản
                return User.builder()
                        .username(account.getEmail())
                        .password(account.getPassword()) // Lấy mật khẩu từ cơ sở dữ liệu
//                        .roles(account.getRole()) // Giả sử bạn có trường "role"
                        .build();
            }
        };
    }
}
