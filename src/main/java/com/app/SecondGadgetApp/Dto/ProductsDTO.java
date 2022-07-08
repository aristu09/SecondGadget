package com.app.SecondGadgetApp.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class ProductsDTO
{
    private Long productId;
    private Long categoryId;
    private Long userId;
    private String name;
    private String serialNumber;
    private BigDecimal price;
    private String description;
    private String status;
    private MultipartFile photo;
    private Date createdAt;
    private Date updatedAt;
}
