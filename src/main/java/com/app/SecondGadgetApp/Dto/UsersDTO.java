package com.app.SecondGadgetApp.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UsersDTO
{
    private Long userId;
    private String username;
    private String fullName;
    private String phone;
    private String address;
    private String email;
    private String password;
    private MultipartFile img;
    private int roleId;
}
