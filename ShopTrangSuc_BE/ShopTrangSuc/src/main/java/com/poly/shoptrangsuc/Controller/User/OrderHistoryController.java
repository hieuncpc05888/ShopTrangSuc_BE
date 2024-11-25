//package com.poly.shoptrangsuc.Controller.User;
//import com.poly.shoptrangsuc.Model.Account;
//import com.poly.shoptrangsuc.Model.Order;
//import com.poly.shoptrangsuc.Service.OrderService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/orders-history")
//public class OrderHistoryController {
//    private static final Logger logger = LoggerFactory.getLogger(OrderHistoryController.class);
//
//    private final AccountRepository accountRepository;
//    private final OrderService orderService;
//
//    public OrderHistoryController(AccountRepository accountRepository, OrderService orderService) {
//        this.accountRepository = accountRepository;
//        this.orderService = orderService;
//    }
//
//    @GetMapping("/account/{accountId}")
//    public ResponseEntity<List<Order>> getOrdersByAccount(@PathVariable Integer accountId) {
//        Optional<Account> accountOptional = accountRepository.findById(accountId);
//
//        if (accountOptional.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(null); // Optionally return a message or a different response body
//        }
//
//        Account account = accountOptional.get();
//        List<Order> orders = orderService.getOrdersByAccount(account);
//        return ResponseEntity.ok(orders);
//    }
//}
