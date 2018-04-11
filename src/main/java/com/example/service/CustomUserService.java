package com.example.service;

import com.example.bean.SysUser;
import com.example.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println(user.getUsername());
        return user;
    }
}
