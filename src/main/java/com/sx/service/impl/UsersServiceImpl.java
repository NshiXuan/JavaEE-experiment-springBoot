package com.sx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sx.common.cache.Caches;
import com.sx.common.enhance.MyLambdaQueryWrapper;
import com.sx.common.mapStruct.MapStructs;
import com.sx.common.util.Constants;
import com.sx.common.util.JsonVos;
import com.sx.mapper.UsersMapper;
import com.sx.pojo.po.Users;
import com.sx.pojo.result.CodeMsg;
import com.sx.pojo.vo.LoginVo;
import com.sx.pojo.vo.req.LoginReqVo;
import com.sx.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service("usersService")
@Transactional
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

  @Override
  public LoginVo login(LoginReqVo reqVo) {
    MyLambdaQueryWrapper<Users> wrapper = new MyLambdaQueryWrapper<>();
    wrapper.eq(Users::getUsername, reqVo.getUsername());
    Users po = baseMapper.selectOne(wrapper);
    if (po == null) {
      return JsonVos.raise(CodeMsg.WRONG_USERNAME);
    }

    if (!po.getPassword().equals(reqVo.getPassword())) {
      return JsonVos.raise(CodeMsg.WRONG_PASSWORD);
    }

    if (po.getStatus() == Constants.userStatus.LOCKED) {
      return JsonVos.raise(CodeMsg.USER_LOCKED);
    }

    // 生成token存储到缓存中，并发给用户
    String token = UUID.randomUUID().toString();
    Caches.putToken(token, po);
    LoginVo vo = MapStructs.INSTANCE.po2loginVo(po);
    vo.setToken(token);

    return vo;
  }
}

