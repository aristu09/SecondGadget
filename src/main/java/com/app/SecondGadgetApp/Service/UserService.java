//package com.app.SecondGadgetApp.Service;
//
//import com.app.SecondGadgetApp.Dto.UsersDTO;
//import com.app.SecondGadgetApp.Entity.Users;
//import com.app.SecondGadgetApp.Repository.UserRepo;
//import com.app.SecondGadgetApp.Status.ResultStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class UserService
//{
//    @Autowired
//    UserRepo userRepo;
//
//    public Users add_user(UsersDTO userDto, MultipartFile file) throws IOException {
//        Users user = new Users();
//        user.setUsername(userDto.getUsername());
//        user.setFullName(userDto.getFullName());
//        user.setAddress(userDto.getAddress());
//        user.setNoTlp(userDto.getNoTlp());
//        user.setImg(file.getBytes());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        userRepo.save(user);
//        return user;
//    }
//
////    public ResultStatus add_user
//
//    public List<Users> display_all()
//    {
//        return userRepo.findAll();
//    }
//
//    public Users display_by_id(Long user_id)
//    {
//        return userRepo.findByUserId(user_id);
//    }
//
//    public List<Users> update_user(long userId, UsersDTO userDto, MultipartFile file) {
//        try {
//            Users user = userRepo.findByUserId(userId);
//            if (user != null){
//                user.setUsername(userDto.getUsername());
//                user.setFullName(userDto.getFullName());
//                user.setEmail(userDto.getEmail());
//                user.setPassword(userDto.getPassword());
//                user.setAddress(userDto.getAddress());
//                user.setNoTlp(userDto.getNoTlp());
//                user.setImg(file.getBytes());
//                Users userupdate = userRepo.save(user);
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//            System.out.println("user not found");
//        }
//        return null;
//    }
//
//    public Boolean delete_user(Long user_id)
//    {
//        if(userRepo.existsById(user_id))
//        {
//            userRepo.deleteById(user_id);
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
//}
