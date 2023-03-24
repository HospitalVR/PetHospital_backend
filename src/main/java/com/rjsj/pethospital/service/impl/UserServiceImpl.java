package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.User;
import com.rjsj.pethospital.repository.UserRepository;
import com.rjsj.pethospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Optional<User> exist = userRepository.findByUserName(user.getUserName());
        exist.ifPresent(value -> {
            user.setId(value.getId());
            user.setPassword(value.getPassword());
        });
        return userRepository.save(user);
    }

    @Override
    public User updatePassword(String userName, String password) {
        Optional<User> user = userRepository.findByUserName(userName);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.ifPresent(value -> {
            value.setPassword(passwordEncoder.encode(password));
            userRepository.save(value);
        });
        return user.orElse(null);
    }

    @Override
    public void deleteByName(String userName) {
        userRepository.deleteByUserName(userName);
    }
}
