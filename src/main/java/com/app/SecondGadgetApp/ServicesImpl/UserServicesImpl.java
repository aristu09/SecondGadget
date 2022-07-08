package com.app.SecondGadgetApp.ServicesImpl;

import com.app.SecondGadgetApp.Dto.UsersDTO;
import com.app.SecondGadgetApp.Entity.Role;
import com.app.SecondGadgetApp.Entity.Users;
import com.app.SecondGadgetApp.Repository.RoleRepo;
import com.app.SecondGadgetApp.Repository.UserRepo;
import com.app.SecondGadgetApp.Service.UserServices;
import com.app.SecondGadgetApp.Status.ResultStatus;
import com.app.SecondGadgetApp.Status.SuccessDataReslut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServicesImpl implements UserServices, UserDetailsService {
    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final RoleRepo roleRepo;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Users findByEmail(String email) {

        return  userRepo.findByEmail(email);
    }

    @Override
    public ResultStatus saveUsers(UsersDTO usersDTO) {
        Users saveUsers = new Users();
        saveUsers.setUsername(usersDTO.getUsername());
        saveUsers.setFullName(usersDTO.getFullName());
        saveUsers.setEmail(usersDTO.getEmail());
        List<Role> getRoleById = roleRepo.findByRoleId(1);
        saveUsers.setRoles(getRoleById);
        saveUsers.setPassword(bCryptPasswordEncoder.encode(usersDTO.getPassword()));
        userRepo.save(saveUsers);
        return new SuccessDataReslut(usersDTO, "Register Success");
    }

    @Override
    public ResultStatus saveSeller(UsersDTO usersDTO) {
        Users saveUsers = new Users();
        saveUsers.setUsername(usersDTO.getUsername());
        saveUsers.setFullName(usersDTO.getFullName());
        saveUsers.setEmail(usersDTO.getEmail());
        List<Role> getRoleById = roleRepo.findByRoleId(2);
        saveUsers.setRoles(getRoleById);
        saveUsers.setPassword(bCryptPasswordEncoder.encode(usersDTO.getPassword()));
        userRepo.save(saveUsers);
        return new SuccessDataReslut(usersDTO, "Register Success");
    }


    //    @Override
//    public ResultStatus saveUser(UsersDTO userDto){
//        Users saveUser = new Users();
//        saveUser.setUsername(userDto.getUsername());
//        saveUser.setFullName(userDto.getFullName());
//        saveUser.setEmail(userDto.getEmail());
//        List<Role> getRoleById = roleRepo.findByRoleId(1);
//        saveUser.setRoleName(getRoleById);
//        if (saveUser != null){
//            throw new IllegalArgumentException(String.format("Users already exists", userDto.getUsername()));
//        }
//        saveUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        return new SuccessDataReslut(userDto, "Register Success");
//    }

    @Override
    public ResultStatus getAllUsers() {
        List<Users> users =userRepo.findAll();
        return new SuccessDataReslut<>(users,"Success Get All Users");
    }

    @Override
    public ResultStatus getUserById(Long user_id) {
        Users users = userRepo.findByUserId(user_id);
        return new SuccessDataReslut<>(users,"Success Get Users By Id");
    }


    public ResultStatus update_user(long userId, UsersDTO usersDTO, MultipartFile file) {

        Users users = userRepo.findByUserId(userId);
        users.setUsername(users.getUsername());
        users.setFullName(users.getFullName());
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        users.setAddress(users.getAddress());
        users.setEmail(users.getEmail());
        users.setPhone(users.getPhone());
        users.setImg(users.getImg());
        userRepo.save(users);
        return new SuccessDataReslut<>("Success Update Users");
    }

    @Override
    public ResultStatus deleteUser(Long user_id) {
        Users users = userRepo.findByUserId(user_id);
        if (users != null){
            userRepo.deleteById(user_id);
        }
        return new ResultStatus(true,"Success Deleted Users");
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepo.findByEmail(email);
        log.info("username users :" + email);
        if(users != null){
            log.info("Users found in the database : {}", email);
        }else{
            log.error("Users not found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        users.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), authorities);

    }
}
