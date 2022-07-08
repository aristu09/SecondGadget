//package com.app.SecondGadgetApp.Controller;
//
//import com.app.SecondGadgetApp.Dto.UsersDTO;
//import com.app.SecondGadgetApp.Entity.Users;
//import com.app.SecondGadgetApp.ServicesImpl.UserLoginServiceImpl;
//import com.app.SecondGadgetApp.Status.LoginStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class LoginController {
//    @Autowired
//    UserLoginServiceImpl userLoginServiceImpl;
//
//    @PostMapping("/registration")
////    @ResponseBody
//    public ResponseEntity<?> registration (@RequestBody UsersDTO userDto)
//    {
//        Map<String, String> map = new HashMap<>();
//        Users userLogin = userLoginServiceImpl.findByEmail(userDto.getEmail());
//        Users findUsername = userLoginServiceImpl.findByUsername(userDto.getUsername());
//
//        if(userLogin != null)
//        {
//            map.put(userDto.getEmail(), "email already exist");
//            return new ResponseEntity<>(LoginStatus.EMAIL_EXIST.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        else
//        {
//            if(findUsername != null)
//            {
//                map.put(userDto.getUsername(), "username already exist");
//                return new ResponseEntity<>(LoginStatus.USERNAME_EXIST.getMessage(), HttpStatus.BAD_REQUEST);
//            }
//            else
//            {
//                userLoginServiceImpl.saveUser(userDto);
//            }
//            return  new ResponseEntity<>(LoginStatus.ACCEPTED.getMessage(), HttpStatus.CREATED);
//        }
//    }
//
//    @PostMapping("/registration-seller")
//    public ResponseEntity<?> registrationSeller (@RequestBody UsersDTO user)
//    {
//        Map<String, String> map = new HashMap<>();
//        Users userLogin = userLoginServiceImpl.findByEmail(user.getUsername());
//        if (userLogin != null) {
//            map.put(user.getUsername(), "username already exist");
//            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
//        }else {
//            userLoginServiceImpl.postUser(user);
//        }
//        return  new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login (@RequestBody Users user){
//        Users userLogin = userLoginServiceImpl.findByEmail(user.getEmail());
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }
//}
