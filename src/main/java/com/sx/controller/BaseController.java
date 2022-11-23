package com.sx.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.common.util.JsonVos;
import com.sx.pojo.result.CodeMsg;
import com.sx.pojo.vo.JsonVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.function.Function;

@Validated
public abstract class BaseController<Po, ReqVo> {
  // IService泛型与po挂钩，与数据库挂钩，不能乱改
  protected abstract IService<Po> getService();

  // reqVo转成Po
  protected abstract Function<ReqVo, Po> getFunction();

  @PostMapping("/remove")
  @ApiOperation("删除一个或多个数据")
  public JsonVo remove(@NotBlank(message = "id不能为空")
                       @Min(0) // RequestParam让返回id为query类型
                       @RequestParam String id) {
    String[] idStrs = id.split(",");
    if (getService().removeByIds(Arrays.asList(idStrs))) {
      return JsonVos.ok(CodeMsg.REMOVE_OK);
    } else {
      return JsonVos.raise(CodeMsg.REMOVE_ERROR);
    }
  }

  @PostMapping("/save")
  @ApiOperation("添加或者更新")
  public JsonVo save(@Valid @RequestBody ReqVo reqVo) {
    // 把reqVo转成po
    Po po = getFunction().apply(reqVo);
    if (getService().saveOrUpdate(po)) {
      return JsonVos.ok(CodeMsg.SAVE_OK);
    } else {
      return JsonVos.raise(CodeMsg.SAVE_ERROR);
      // return JsonVos.error("保存失败");
    }
  }
}
