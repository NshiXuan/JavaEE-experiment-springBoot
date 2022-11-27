package com.sx.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.common.mapStruct.MapStructs;
import com.sx.common.shiro.TokenFilter;
import com.sx.common.util.Constants;
import com.sx.common.util.JsonVos;
import com.sx.pojo.po.Goods;
import com.sx.pojo.vo.JsonVo;
import com.sx.pojo.vo.PageJsonVo;
import com.sx.pojo.vo.list.GoodsVo;
import com.sx.pojo.vo.req.page.GoodsPageReqVo;
import com.sx.pojo.vo.req.save.GoodsReqVo;
import com.sx.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.function.Function;

@RestController
@RequestMapping("/goods")
@Api(tags = "商品")
public class GoodsController extends BaseController<Goods, GoodsReqVo> {
  @Autowired
  private GoodsService service;

  @GetMapping
  @ApiOperation("分页查询")
  @RequiresPermissions(Constants.Permisson.GOOD_LIST)
  public PageJsonVo<GoodsVo> list(GoodsPageReqVo reqVo) {
    return JsonVos.ok(service.list(reqVo));
  }

  @Override
  // 有下面两个权限中的一个都可以访问
  @RequiresPermissions(value = {
          Constants.Permisson.GOOD_ADD,
          Constants.Permisson.GOOD_UPDATE
  }, logical = Logical.OR)
  public JsonVo save(@RequestBody GoodsReqVo reqVo) {
    return super.save(reqVo);
  }

  @Override
  @RequiresPermissions(Constants.Permisson.GOOD_REMOVE)
  public JsonVo remove(String id) {
    return super.remove(id);
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

