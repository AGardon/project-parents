package com.xiaoyi.po;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "sys_role")
public class SysRole {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long roleId;

  private String roleName;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    SysRole sysRole = (SysRole) o;
    return roleId != null && Objects.equals(roleId, sysRole.roleId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
