package com.xiaoyi.service.serviceImpl;

import com.xiaoyi.dto.SysUserDto;
import com.xiaoyi.exception.ResultBody;
import com.xiaoyi.po.SysUser;
import com.xiaoyi.repo.SysUserRepository;
import com.xiaoyi.service.UserService;
import com.xiaoyi.utils.MD5Utils;
import com.xiaoyi.utils.SaltUtils;
import com.xiaoyi.vo.SysUserVo;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王艺翔
 * @description UserServiceImpl
 * @date 2022/10/18 17:33
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github <a href="https://github.com/AGarden">...</a>
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  private final SysUserRepository userRepository;
  //  private final DtoToPo convert;

  @Override
  public ResultBody getUser(String userName) {
    SysUser user = userRepository.findByUserName(userName);
    return ResultBody.success(new SysUserVo(user.getUserName(), user.getRealName()));
  }

  @Override
  public ResultBody registerUser(SysUserDto userDto) {
    log.info("添加用户");
    SysUser user = new SysUser();
    user.setUserName(userDto.userName());
    user.setRealName(userDto.realName());
    String salt = SaltUtils.getSalt();
    user.setSalt(salt);
    user.setPassword(MD5Utils.md5(userDto.password() + salt));
    userRepository.save(user);
    return ResultBody.success();
  }
}
