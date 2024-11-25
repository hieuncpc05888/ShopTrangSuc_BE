package com.poly.shoptrangsuc.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Blog_Comment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "content")
    private String content;

    @Column(name = "comment_date")
    private java.sql.Date commentDate;

    @Column(name = "comment_name")
    private String commentName;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private BlogPost blogPost;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}