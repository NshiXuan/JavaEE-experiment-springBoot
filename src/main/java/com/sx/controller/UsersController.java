package com.sx.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.common.cache.Caches;
import com.sx.common.mapStruct.MapStructs;
import com.sx.common.shiro.TokenFilter;
import com.sx.common.util.JsonVos;
import com.sx.filter.ErrorFilter;
import com.sx.pojo.po.Users;
import com.sx.pojo.result.CodeMsg;
import com.sx.pojo.vo.DataJsonVo;
import com.sx.pojo.vo.JsonVo;
import com.sx.pojo.vo.LoginVo;
import com.sx.pojo.vo.req.LoginReqVo;
import com.sx.pojo.vo.req.save.UsersReqVo;
import com.sx.service.UsersService;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Function;

@RestController
@RequestMapping("/users")
@Api(tags = "用户")
public class UsersController extends BaseController<Users, UsersReqVo> {
  @Autowired
  private UsersService service;

  @GetMapping("/captcha")
  @ApiOperation("生成验证码")
  public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
    CaptchaUtil.out(request, response);
  }

  @PostMapping("/login")
  @ApiOperation("登录")
  public DataJsonVo<LoginVo> login(@RequestBody LoginReqVo reqVo, HttpServletRequest request) {
    // 验证验证码
    System.out.println(reqVo.getCaptcha());
    // System.out.println(request.);
    if (!CaptchaUtil.ver(reqVo.getCaptcha(), request)) {
      return JsonVos.ok(service.login(reqVo));
    }
    return JsonVos.raise(CodeMsg.WRONG_CAPTCHA);
  }

  @PostMapping("/logout")
  @ApiOperation("退出登录")
  public JsonVo logout(@RequestHeader(TokenFilter.HEADER_TOKEN) String token) {
    // System.out.println("logout" + token);
    Caches.removeToken(token);
    return JsonVos.ok();
  }

  @Override
  protected IService<Users> getService() {
    return service;
  }

  @Override
  protected Function<UsersReqVo, Users> getFunction() {
    return MapStructs.INSTANCE::reqVo2po;
  }
}

