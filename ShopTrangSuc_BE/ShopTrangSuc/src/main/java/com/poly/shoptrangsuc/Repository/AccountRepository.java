package com.poly.shoptrangsuc.Repository;

import com.poly.shoptrangsuc.Model.Account;
import com.poly.shoptrangsuc.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmail(String email);

    Account findByRole(Role role);
}