package com.sx.pojo.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("聊天记录")
public class ChatVo {
  //主键
  @ApiModelProperty("id")
  private String id;
  //聊天内容
  @ApiModelProperty("聊天内容")
  private String content;
  //用户id
  @ApiModelProperty("用户id")
  private String userId;

  @ApiModelProperty("用户名称")
  private String userName;
}
