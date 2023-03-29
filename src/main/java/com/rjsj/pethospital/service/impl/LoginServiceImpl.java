package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.component.RedisCache;
import com.rjsj.pethospital.entity.LoginUser;
import com.rjsj.pethospital.entity.User;
import com.rjsj.pethospital.service.LoginService;
import com.rjsj.pethospital.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public Map<String, String> login(User user) {
        Map<String, String> map = new HashMap<>();
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
            String userId = loginUser.getUser().getId().toString();
            String jwt = JwtUtil.createJWT(userId);
            redisCache.setCacheObject("login:" + userId, loginUser);
            map.put("message", "登录成功");
            map.put("token", jwt);
            map.put("type", loginUser.getUser().getUserType());
        } catch (Exception e) {
            map.put("message", "用户名或密码错误");
        }
        return map;
    }

    @Override
    public Map<String, String> logout() {
        Map<String, String> map = new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redisCache.deleteObject("login:" + userid);
        map.put("message", "注销成功");
        return map;
    }

    @Override
    public Map<String, String> verify(String token) {
        Map<String, String> map = new HashMap<>();
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
            Object object = redisCache.getCacheObject("login:" + userid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        return map;
    }
}