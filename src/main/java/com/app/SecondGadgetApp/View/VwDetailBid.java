package com.app.SecondGadgetApp.View;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "vw_detail_bid")
public class VwDetailBid
{
    @Id
    @Column(name = "bid_id")
    private Long bidId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "bid_price")
    private BigDecimal bidPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;
}
