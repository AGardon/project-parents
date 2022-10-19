package com.xiaoyi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.xiaoyi.po.SysUser} entity
 */

@ApiModel("用户基本信息")
public record SysUserDto(
		@ApiModelProperty("昵称")@Size(max = 20)
		String userName,
		@ApiModelProperty("姓名")@Size(max = 20)
		String realName,
		@ApiModelProperty("密码")@Size(min = 6,max = 16)
		String password
) implements Serializable {}
