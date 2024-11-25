package com.poly.shoptrangsuc;

import com.poly.shoptrangsuc.Model.Account;
import com.poly.shoptrangsuc.Model.Role;
import com.poly.shoptrangsuc.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;;

@SpringBootApplication
public class ShopTrangSucApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopTrangSucApplication.class, args);
	}
}
