package com.gy.daemon.service;

import com.gy.daemon.dto.dao.GUserDao;
import com.gy.daemon.dto.db.GUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang_gao on 2017/10/11.
 */

@Service
public class GUserDetailService implements UserDetailsService {


    @Autowired
    private GUserDao gUserDao;

    private static String YES = "yes";
    private static String NO = "no";

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        GUserDto user = gUserDao.selectByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with the username %s doesn't exist", userName));
        }
        if (user.getAdmin().equals(YES)) {
            authorityList = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
        }
        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), authorityList);
        return userDetails;
    }
}
