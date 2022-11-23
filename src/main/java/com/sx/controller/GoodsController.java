package com.sx.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.common.mapStruct.MapStructs;
import com.sx.common.shiro.TokenFilter;
import com.sx.common.util.JsonVos;
import com.sx.pojo.po.Goods;
import com.sx.pojo.vo.PageJsonVo;
import com.sx.pojo.vo.list.GoodsVo;
import com.sx.pojo.vo.req.page.GoodsPageReqVo;
import com.sx.pojo.vo.req.save.GoodsReqVo;
import com.sx.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping("/goods")
@Api(tags = "商品")
public class GoodsController extends BaseController<Goods, GoodsReqVo> {
  @Autowired
  private GoodsService service;

  @GetMapping
  @ApiOperation("分页查询")
  public PageJsonVo<GoodsVo> list(GoodsPageReqVo reqVo) {
    return JsonVos.ok(service.list(reqVo));
  }

  @Override
  protected IService<Goods> getService() {
    return service;
  }

  @Override
  protected Function<GoodsReqVo, Goods> getFunction() {
    return MapStructs.INSTANCE::reqVo2po;
  }
}

