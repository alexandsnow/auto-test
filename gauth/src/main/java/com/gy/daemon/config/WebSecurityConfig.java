package com.gy.daemon.config;

import com.gy.daemon.service.GUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by yang_gao on 2017/10/11.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法级别的endpoint鉴权
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    private GUserDetailService gUserDetailService;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * specify a authenticate way [inMemory inDB]
     * @param auth
     * @throws Exception
     */
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(gUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }



    /**
     * Specify the URI that should be secured or unsecured
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                    .antMatchers("/heartbeat/**","/tool/**").permitAll()   // do not need secured
                    .antMatchers("/v1/**").authenticated().and()  // need secured
                .httpBasic()
                .realmName("GAuth").and()
                .csrf().disable();  //todo must create a specify Class to enable csrf
    }
}
