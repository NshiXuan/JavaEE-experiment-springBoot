package com.sx.pojo.po;

import lombok.Data;

@Data
public class Chat {
  //主键
  private String id;
  //聊天内容
  private String content;
  //用户id
  private String userId;
}
