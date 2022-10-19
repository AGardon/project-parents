package com.xiaoyi.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 王艺翔
 * @description SysUserVo
 * @date 2022/10/19 21:49
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github <a href="https://github.com/AGarden">...</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserVo {
  @ApiModelProperty("昵称")
  private String userName;

  @ApiModelProperty("姓名")
  private String realName;
}
