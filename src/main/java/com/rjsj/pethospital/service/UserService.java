package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> findAllCommonUser();

    User save(User user);

    Map<String, String> updatePassword(String userName, String oldPassword, String newPassword);

    void deleteByName(String name);

}
