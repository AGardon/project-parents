package com.xiaoyi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author 王艺翔
 * @description SecurityConfig
 * @date 2022/10/20 11:49
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github <a href="https://github.com/AGarden">...</a>
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final UserDetailsService service;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity.cors().disable().csrf().disable().formLogin().and().build();
  }
}
