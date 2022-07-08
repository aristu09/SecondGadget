package com.app.SecondGadgetApp.Repository;

import com.app.SecondGadgetApp.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
//
@Repository
@Transactional
public interface UserRepo extends JpaRepository<Users, Long>
{
    List<Users> findAll();
    Users findByUserId(Long user_id);
    Users findByUsername(String username);
    Users findByEmail(String email);
    }
