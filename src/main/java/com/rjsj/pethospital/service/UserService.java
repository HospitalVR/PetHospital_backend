package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllCommonUser();

    User save(User user);

    User updatePassword(String userName, String password);

    void deleteByName(String name);

}
