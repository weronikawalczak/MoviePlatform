package com.example.demo.security;

import com.example.demo.repository.SystemUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private SystemUserRepository systemUserRepository;

    public SecurityConfig(SystemUserRepository systemUserRepository){
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/unsecured").permitAll()
                    .antMatchers(HttpMethod.GET, "/movie/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/favourite/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/towatch/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/admin/ban/**").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST, "/register").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new MoviesUserDetailsService(systemUserRepository);
    }
}




