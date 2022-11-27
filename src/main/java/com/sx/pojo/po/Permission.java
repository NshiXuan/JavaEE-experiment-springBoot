package com.sx.pojo.po;

import lombok.Data;

@Data
public class Permission {
  //主键
  private Short id;
  //名称
  private String name;
  //权限标识
  private String permission;
}
