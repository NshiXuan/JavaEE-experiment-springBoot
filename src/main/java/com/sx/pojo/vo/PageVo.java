package com.sx.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("分页结果")
@Data
public class PageVo<T> {
  @ApiModelProperty("总数")
  private Long total;

  @ApiModelProperty("总页数")
  private Long pages;

  @ApiModelProperty("数据")
  private List<T> data;
}
