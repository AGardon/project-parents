package com.xiaoyi.po;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author wangyixiang
 * @description SysUser
 * @date 2022/10/18 17:05
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class SysUser {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;

  private String userName;
  private String realName;
  private String password;
  private String salt;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    SysUser sysUser = (SysUser) o;
    return userId != null && Objects.equals(userId, sysUser.userId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
