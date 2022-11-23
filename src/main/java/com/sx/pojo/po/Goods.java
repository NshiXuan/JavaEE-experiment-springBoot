package com.sx.pojo.po;

import java.math.BigInteger;

import lombok.Data;

@Data
public class Goods {
  //主键
  private String id;
  //商品名称
  private String goodName;
  //商品价格
  private BigInteger goodPrice;
  //商品图片
  private String goodImg;
}
