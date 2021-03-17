package com.springbootcamp.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    UserRepository userRepository;

    @Transactional
    AppUser loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        System.out.println(user);

        if (username != null) {

            List<GrantAuthorityImpl> grantAuthorityList=new ArrayList<>();
            List<Role> roles=user.getRoles();

            for(Role role: roles)
            {
                grantAuthorityList.add(new GrantAuthorityImpl(role.getName()));

            }

            return new AppUser(user.getUsername(),
                    user.getPassword(),
                    grantAuthorityList);
        }
        else {
            throw new RuntimeException();
        }

    }
}
