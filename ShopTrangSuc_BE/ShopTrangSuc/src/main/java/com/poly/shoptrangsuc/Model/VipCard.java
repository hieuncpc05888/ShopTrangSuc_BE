package com.poly.shoptrangsuc.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "VIP_Card")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VipCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vipcard_id")
    private Integer vipCardId;

    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "expiration_date")
    private java.sql.Date expirationDate;

    @Column(name = "discount_percentage")
    private Integer discountPercentage;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
