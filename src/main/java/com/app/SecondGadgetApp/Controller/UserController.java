package com.app.SecondGadgetApp.Controller;

import com.app.SecondGadgetApp.Dto.UsersDTO;
import com.app.SecondGadgetApp.Entity.Users;
import com.app.SecondGadgetApp.Service.UserServices;
//import com.app.SecondGadgetApp.ServicesImpl.UserLoginServiceImpl;
//import com.app.SecondGadgetApp.Service.UserService;
//import com.app.SecondGadgetApp.ServicesImpl.CloudinaryServicesImpl;
import com.app.SecondGadgetApp.ServicesImpl.UserServicesImpl;
import com.app.SecondGadgetApp.Status.ResultStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserServices userService;

    @Autowired
    UserServicesImpl userLoginService;

//    @Autowired
//    private final CloudinaryServices cloudinaryServices;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/registration")
    public ResponseEntity<ResultStatus> saveUsers(@RequestBody UsersDTO usersDto) {
        Users users = modelMapper.map(usersDto, Users.class);
        return new ResponseEntity<>(userService.saveUsers(usersDto), HttpStatus.CREATED);
    }

    @PostMapping("/registration-seller")
    public ResponseEntity<ResultStatus> saveSeller(@RequestBody UsersDTO usersDto) {
        Users users = modelMapper.map(usersDto, Users.class);
        return new ResponseEntity<>(userService.saveSeller(usersDto), HttpStatus.CREATED);
    }

    @GetMapping("display-all")
    public ResponseEntity<ResultStatus> getAllUsers()
    {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("display-by-id/{user_id}")
    public ResponseEntity<ResultStatus> getUsersById(@PathVariable("user_id") Long user_id)
    {
        return new ResponseEntity<>(userService.getUserById(user_id), HttpStatus.ACCEPTED);
    }

//    @PutMapping("update-user/{userId}")
//    public ResponseEntity<ResultStatus> update_response(@PathVariable long userId , UsersDTO userDto, @RequestParam("img")MultipartFile file, Authentication authentication) throws Exception
//    {
//        String username = authentication.getName();
////        Users user = modelMapper.map(userDto, Users.class);
//        Map<?,?> uploaImage =(Map<?,?>)cloudinaryServices.upload(userDto.getImg()).getData();
//        Users user = new Users();
//        user.setUsername(userDto.getUsername());
//        user.setFullName(userDto.getFullName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAddress(userDto.getAddress());
//        user.setNoTlp(userDto.getNoTlp());
//        user.setImg(uploaImage.get("url").toString());
//       return new ResponseEntity<>(userService.saveUsers(userDto), HttpStatus.ACCEPTED);
//    }

    @DeleteMapping("delete-user/{user_id}")
    public ResponseEntity<ResultStatus> delete_response(@PathVariable ("user_id") Long user_id)
    {
            return new ResponseEntity<>(userService.deleteUser(user_id), HttpStatus.ACCEPTED);
    }
}
