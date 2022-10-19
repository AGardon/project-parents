package com.xiaoyi.repo;

import com.xiaoyi.po.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
  SysUser findByUserName(String userName);
}
