package com.poly.shoptrangsuc.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "Search_History")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_history_id")
    private Integer searchHistoryId;

    @ManyToOne
    @JoinColumn(name = "account_id") // Establishing the relationship with Account
    private Account account;

    @Column(name = "search_keyword")
    private String searchKeyword;

    @Column(name = "search_time")
    private Timestamp searchTime;

}