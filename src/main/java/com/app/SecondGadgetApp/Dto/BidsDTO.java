package com.app.SecondGadgetApp.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class BidsDTO
{
    private Long bidId;
    private Long userId;
    private Long productId;
    private BigDecimal bidPrice;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
