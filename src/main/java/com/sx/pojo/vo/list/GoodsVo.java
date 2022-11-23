package com.sx.pojo.vo.list;

import java.math.BigInteger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品")
public class GoodsVo {
  //主键
  @ApiModelProperty("id")
  private String id;
  //商品名称
  @ApiModelProperty("商品名称")
  private String goodName;
  //商品价格
  @ApiModelProperty("商品价格")
  private BigInteger goodPrice;
  //商品图片
  @ApiModelProperty("商品图片")
  private String goodImg;
}
