package com.sx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sx.common.enhance.MyLambdaQueryWrapper;
import com.sx.common.util.Streams;
import com.sx.mapper.PermissionMapper;
import com.sx.pojo.po.Permission;
import com.sx.pojo.po.UserPermission;
import com.sx.service.PermissionService;
import com.sx.service.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
  @Autowired
  private UserPermissionService userPermissionService;


  @Override
  public List<Short> listIds(Integer userId) {
    if (userId == null || userId <= 0) return null;

    MyLambdaQueryWrapper<UserPermission> wrapper = new MyLambdaQueryWrapper<>();
    wrapper.select(UserPermission::getPermissionId);
    wrapper.eq(UserPermission::getUserId, userId);

    List<Object> ids = userPermissionService.listObjs(wrapper);
    // for (Object id : ids) {
    //   // getClass可以拿到id的类型
    //   System.out.println(id + " - " + id.getClass());
    // }

    return Streams.map(ids, id -> ((Integer) id).shortValue());
  }

  @Override
  public List<Permission> listByUserId(Integer userId) {
    if (userId == null || userId <= 0) return null;
    List<Short> ids = listIds(userId);
    if (CollectionUtils.isEmpty(ids)) return null;
    MyLambdaQueryWrapper<Permission> wrapper = new MyLambdaQueryWrapper<>();
    wrapper.in(Permission::getId, ids);
    return baseMapper.selectList(wrapper);
  }

  @Override
  public List<Permission> listPermission(Integer userId) {
    return baseMapper.selectPermission(userId);
  }
}

