package com.sx.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录成功结果")
public class LoginVo {
  @ApiModelProperty("id")
  private Integer id;

  @ApiModelProperty("用户名")
  private String username;

  @ApiModelProperty("token登录令牌")
  private String token;
}
