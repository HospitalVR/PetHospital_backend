package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.User;
import com.rjsj.pethospital.repository.UserRepository;
import com.rjsj.pethospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllCommonUser() {
        return userRepository.findAllByUserTypeEquals("user");
    }

    @Override
    public User save(User user) {
        user.setUserType("user");
        if (user.getId() != null && user.getId() != 0) {
            Optional<User> option = userRepository.findById(user.getId());
            if (option.isPresent() && !option.get().getUserName().equals(user.getUserName())) {
                if (userRepository.findByUserName(user.getUserName()).isPresent())
                    return null;
            }
        } else {
            if (userRepository.findByUserName(user.getUserName()).isPresent())
                return null;
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteByName(String userName) {
        userRepository.deleteByUserName(userName);
    }
}
