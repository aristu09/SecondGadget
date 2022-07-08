package com.app.SecondGadgetApp.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class CategoriesDTO
{
    private Long categoryId;
    private MultipartFile photo;
    private String name;
}
