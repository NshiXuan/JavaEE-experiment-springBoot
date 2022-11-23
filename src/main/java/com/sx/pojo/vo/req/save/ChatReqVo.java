package com.sx.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ChatReqVo {
  //主键
  @ApiModelProperty("【大于0代表更新，否则代表添加】")
  private String id;
  //聊天内容
  @NotBlank(message = "内容不能为空")
  @ApiModelProperty(value = "聊天内容",required = true)
  private String content;
  //用户id
  @NotNull(message = "用户id不能为空")
  @ApiModelProperty(value = "用户id",required = true)
  private String userId;
}
