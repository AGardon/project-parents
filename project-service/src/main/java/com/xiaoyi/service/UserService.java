package com.xiaoyi.service;

import com.xiaoyi.dto.SysUserDto;
import com.xiaoyi.exception.ResultBody;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author 王艺翔
 * @description UserService
 * @date 2022/10/18 17:30
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github <a href="https://github.com/AGarden">...</a>
 */
public interface UserService {

  @PutMapping("/getUser/{username}")
  @ApiOperation("根据用户昵称查询用户")
  ResultBody getUser(@PathVariable(value = "username") String userName);

  @PostMapping("/register")
  @ApiOperation("创建用户")
  ResultBody registerUser(@RequestBody @Valid SysUserDto user);
}
