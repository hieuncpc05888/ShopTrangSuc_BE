package com.poly.shoptrangsuc.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "totat_amount", precision = 10, scale = 2)
    private BigDecimal totatAmount;

    @Column(name = "promotional_discount")
    private Integer promotionalDiscount;

    @Column(name = "vip_discount")
    private Integer vipDiscount;

    @Column(name = "address")
    private String address;

    @Column(name = "totat_amount_after_discount", precision = 10, scale = 2)
    private BigDecimal totatAmountAfterDiscount;

    @ManyToOne
    @JoinColumn(name = "shipping_method_id")
    private ShippingMethod shippingMethod;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "payment_id")  // Ensure this matches the column in the Orders table
    private Payment payment;
}