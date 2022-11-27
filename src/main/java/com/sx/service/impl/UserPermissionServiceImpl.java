package com.sx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sx.mapper.UserPermissionMapper;
import com.sx.pojo.po.UserPermission;
import com.sx.service.UserPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userPermissionService")
@Transactional
public class UserPermissionServiceImpl extends ServiceImpl<UserPermissionMapper, UserPermission> implements UserPermissionService {

}

