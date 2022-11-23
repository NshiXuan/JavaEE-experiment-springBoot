package com.sx.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UsersReqVo {
  //id
  @ApiModelProperty("")
  private Integer id;
  //用户名
  @ApiModelProperty("")
  private String username;
  //密码
  @ApiModelProperty("")
  private String password;
  //状态，0是正常，1是锁住
  @ApiModelProperty("")
  private Short status;
}
