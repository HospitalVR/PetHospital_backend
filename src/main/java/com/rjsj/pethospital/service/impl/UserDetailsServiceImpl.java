package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.UserInfo;
import com.rjsj.pethospital.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户不能为空");
        }

        //根据用户名查询用户
        UserInfo user = userInfoRepository.findByUserName(username).orElse(null);

        if (user == null)
            throw new RuntimeException("用户不存在");

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        //获取该用户所拥有的权限
        // List<SysPermission> sysPermissions = sysPermissionService.selectListByUser(sysUser.getId());

        // 声明用户授权
        // sysPermissions.forEach(sysPermission -> {
        //     GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getPermissionCode());
        //     grantedAuthorities.add(grantedAuthority);
        // });

        return new User(user.getAccount(), user.getPassword(), user.isEnabled(), user.isNotExpired(), user.isCredentialsNotExpired(), user.isAccountNotLocked(), grantedAuthorities);
    }
}
