package com.sx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sx.pojo.po.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
  List<Permission> selectPermission(Integer userId);
}
