package com.xiaoyi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
  private final PasswordEncoder passwordEncoder;

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) ->
        web.ignoring()
            // Spring Security should completely ignore URLs starting with /resources/
            .antMatchers("/resources/**");
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/public/**")
        .permitAll()
        .anyRequest()
        .hasRole("USER")
        .and()
        // Possibly more configuration ...
        .formLogin() // enable form based log in
        // set permitAll for all URLs associated with Form Login
        .permitAll();
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user =
        User.builder()
            .username("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .build();
    UserDetails admin =
        User.builder()
            .username("admin")
            .password(passwordEncoder.encode("password"))
            .roles("ADMIN", "USER")
            .build();
    return new InMemoryUserDetailsManager(user, admin);
  }

  // Possibly more bean methods ...
}
