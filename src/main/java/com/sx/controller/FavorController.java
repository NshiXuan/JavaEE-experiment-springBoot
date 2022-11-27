package com.sx.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.common.mapStruct.MapStructs;
import com.sx.common.util.Constants;
import com.sx.common.util.JsonVos;
import com.sx.pojo.po.Favor;
import com.sx.pojo.vo.DataJsonVo;
import com.sx.pojo.vo.JsonVo;
import com.sx.pojo.vo.list.FavorVo;
import com.sx.pojo.vo.req.save.FavorReqVo;
import com.sx.service.FavorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/favors")
@Api(tags = "购物车")
public class FavorController extends BaseController<Favor, FavorReqVo> {
  @Autowired
  private FavorService service;

  @GetMapping
  @ApiOperation("查询所有购物车商品")
  @RequiresPermissions(Constants.Permisson.FAVOR_LIST)
  public DataJsonVo<List<FavorVo>> listFavor() {
    return JsonVos.ok(service.listFavor());
  }

  @Override
  @RequiresPermissions(value = {
          Constants.Permisson.FAVOR_ADD,
          Constants.Permisson.FAVOR_UPDATE
  }, logical = Logical.OR)
  public JsonVo save(@RequestBody FavorReqVo favorReqVo) {
    return super.save(favorReqVo);
  }


  @Override
  @RequiresPermissions(Constants.Permisson.FAVOR_REMOVE)
  public JsonVo remove(String id) {
    return super.remove(id);
  }

  @Override
  protected IService<Favor> getService() {
    return service;
  }

  @Override
  protected Function<FavorReqVo, Favor> getFunction() {
    return MapStructs.INSTANCE::reqVo2po;
  }
}

