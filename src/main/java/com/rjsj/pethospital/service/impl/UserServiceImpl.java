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
        Optional<User> exist = userRepository.findByUserName(user.getUserName());
        if (exist.isPresent()) {
            user.setId(exist.get().getId());
            user.setPassword(exist.get().getPassword());
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    @Override
    public Map<String, String> updatePassword(String userName, String oldPassword, String newPassword) {
        Map<String, String> map = new HashMap<>();
        Optional<User> user = userRepository.findByUserName(userName);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.ifPresent(value -> {
            if (!passwordEncoder.matches(oldPassword, value.getPassword())) {
                map.put("message", "原密码错误");
            } else {
                value.setPassword(passwordEncoder.encode(oldPassword));
                userRepository.save(value);
                map.put("message", "密码修改成功");
            }
        });
        if (!map.containsKey("message")) {
            map.put("message", "用户不存在");
        }
        return map;
    }

    @Override
    public void deleteByName(String userName) {
        userRepository.deleteByUserName(userName);
    }
}
