package com.sx.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FavorReqVo {
  //主键
  @ApiModelProperty("【大于0代表更新，否则代表添加】")
  private String id;
  //商品id
  @NotNull
  @ApiModelProperty(value = "商品id",required = true)
  private String goodId;
  //用户id
  @NotNull
  @ApiModelProperty(value = "用户id",required = true)
  private String userId;
}
