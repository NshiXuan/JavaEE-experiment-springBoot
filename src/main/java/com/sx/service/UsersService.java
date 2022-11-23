package com.sx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.pojo.po.Users;
import com.sx.pojo.vo.LoginVo;
import com.sx.pojo.vo.req.LoginReqVo;

public interface UsersService extends IService<Users> {

  LoginVo login(LoginReqVo reqVo);
}

