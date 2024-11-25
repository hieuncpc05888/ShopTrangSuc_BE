package com.poly.shoptrangsuc.Controller;

import com.poly.shoptrangsuc.Model.Order;
import com.poly.shoptrangsuc.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminContronller {

    @GetMapping
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("From Admin");
    }

}
