package com.sx.pojo.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("购物车商品")
public class FavorVo {
  //主键
  @ApiModelProperty("id")
  private String id;
  //商品id
  @ApiModelProperty("商品id")
  private String goodId;
  //用户id
  @ApiModelProperty("用户id")
  private String userId;

  @ApiModelProperty("商品名称")
  private String goodName;

  @ApiModelProperty("商品价格")
  private String goodPrice;

  @ApiModelProperty("商品图片")
  private String goodImg;
}
