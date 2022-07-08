package com.app.SecondGadgetApp.Repository;

import com.app.SecondGadgetApp.Entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoleRepo extends JpaRepository<Role, Integer> {
     List<Role> findByRoleId(int roleId);
}
