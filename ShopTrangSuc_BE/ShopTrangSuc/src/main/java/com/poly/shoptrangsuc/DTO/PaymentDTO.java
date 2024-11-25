package com.poly.shoptrangsuc.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Integer paymentId;
    private Integer orderId; // Để liên kết với đơn hàng
    private BigDecimal amount;
    private String paymentStatus;
    private LocalDateTime paymentDate;
    private String paymentMethod;
}
