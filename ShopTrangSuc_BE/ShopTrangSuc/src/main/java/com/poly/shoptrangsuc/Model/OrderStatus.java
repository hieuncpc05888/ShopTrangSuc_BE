package com.poly.shoptrangsuc.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Order_Status")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id")
    private Integer orderStatusId;

    @Column(name = "status_name", length = 50)
    private String statusName;

    @Column(name = "describe", length = 255)
    private String describe;

//    @OneToMany(mappedBy = "orderStatus")
//    List<Order> orders;

}