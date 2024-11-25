package com.poly.shoptrangsuc.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Shipping_Method")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShippingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_method_id")
    private Integer shippingMethodId;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "shipping_fee")
    private String shippingFee;

//    @OneToMany(mappedBy = "shippingMethod")
//    private Order order;
}