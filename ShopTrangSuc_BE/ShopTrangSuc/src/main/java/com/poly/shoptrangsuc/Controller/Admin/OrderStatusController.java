package com.poly.shoptrangsuc.Controller.Admin;

import com.poly.shoptrangsuc.Model.OrderDetail;
import com.poly.shoptrangsuc.Model.OrderStatus;
import com.poly.shoptrangsuc.Service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/order-status")
public class OrderStatusController {
    @Autowired
    OrderStatusService orderStatusService;

    @GetMapping
    public ResponseEntity<List<OrderStatus>> getAllOrderStatus() {
        List<OrderStatus> orderStatus = orderStatusService.getAllOrderStatus();
        return new ResponseEntity<>(orderStatus, HttpStatus.OK);
    }
}
