package com.sx.pojo.po;

import lombok.Data;

@Data
public class Users {
  //id
  private Integer id;
  //用户名
  private String username;
  //密码
  private String password;
  //状态，0是正常，1是锁住
  private Short status;
}
