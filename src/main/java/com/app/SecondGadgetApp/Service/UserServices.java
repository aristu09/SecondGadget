package com.app.SecondGadgetApp.Service;

import com.app.SecondGadgetApp.Dto.UsersDTO;
import com.app.SecondGadgetApp.Entity.Users;
import com.app.SecondGadgetApp.Status.ResultStatus;
import org.springframework.stereotype.Component;

@Component
public interface UserServices {
    Users findByEmail(String email);

    //    public Users findByEmail (String email);
//    public Users findByUsername(String username);
//    //    public Users saveUser (UsersDTO user); // new
//    public ResultStatus saveUser(Users user);
//    public List<Users> getAllUsers();
//    public Users postUser(Users user);
//    Optional<Users> getUserById(Integer id);
    ResultStatus saveUsers(UsersDTO usersDTO);

    ResultStatus saveSeller(UsersDTO usersDTO);

    ResultStatus getAllUsers();
    ResultStatus getUserById(Long user_id);
    ResultStatus deleteUser(Long user_id);
}
