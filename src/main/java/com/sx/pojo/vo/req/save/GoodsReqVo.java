package com.sx.pojo.vo.req.save;

import java.math.BigInteger;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GoodsReqVo {
  //主键
  @ApiModelProperty("【大于0代表更新，否则代表添加】")
  private String id;
  //商品名称
  @NotBlank(message = "商品名称不能为空")
  @ApiModelProperty(value = "商品名称不能为空", required = true)
  private String goodName;
  //商品价格
  @NotNull(message = "商品价格不能为空")
  @Min(0)
  @ApiModelProperty(value = "商品价格不能为空", required = true)
  private BigInteger goodPrice;
  //商品图片
  @ApiModelProperty("商品图片")
  private String goodImg;
}
