package com.prshkv.backendproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.prshkv.backendproject.service.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    private final UserDetailServiceImpl userDetailService;

    public WebSecurityConfig(UserDetailServiceImpl userDetailService){
        this.userDetailService = userDetailService;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login").permitAll()
                .requestMatchers("/signup").permitAll()
                .requestMatchers("/").permitAll()
                .requestMatchers("/exploit/**").permitAll()
                .requestMatchers("/saveuser").permitAll()
                .requestMatchers("addPlatform").hasRole("ADMIN")
                .requestMatchers("addType").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(formlogin -> formlogin
            .loginPage("/login")
            .defaultSuccessUrl("/", true)
            .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
            );

            return http.build();
    }

   @Bean
   public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
   }

}