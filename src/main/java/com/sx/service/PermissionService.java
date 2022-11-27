package com.sx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.pojo.po.Permission;

import java.util.List;

public interface PermissionService extends IService<Permission> {
  List<Short> listIds(Integer userId);

  List<Permission> listByUserId(Integer userId);

  List<Permission> listPermission(Integer userId);
}

