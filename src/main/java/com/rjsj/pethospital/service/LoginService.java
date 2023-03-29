package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.User;

import java.util.Map;

public interface LoginService {

    Map<String, String> login(User user);

    Map<String, String> logout();

    Map<String, String> verify(String token);

}
