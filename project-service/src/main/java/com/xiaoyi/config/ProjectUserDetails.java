package com.xiaoyi.config;

import com.xiaoyi.po.SysUser;
import com.xiaoyi.repo.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 王艺翔
 * @description ProjectUserDetails
 * @date 2022/10/20 17:25
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github <a href="https://github.com/AGarden">...</a>
 */
@RequiredArgsConstructor
public class ProjectUserDetails implements UserDetailsService {

  private final SysUserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    SysUser user = userRepository.findByUserName(username);
    Collection<SimpleGrantedAuthority> collection = new ArrayList<>();
    collection.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
    return new User(user.getUserName(), user.getPassword(), collection);
  }
}
