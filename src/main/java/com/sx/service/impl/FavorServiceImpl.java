package com.sx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sx.mapper.FavorMapper;
import com.sx.pojo.po.Favor;
import com.sx.pojo.vo.list.FavorVo;
import com.sx.service.FavorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("favorService")
@Transactional
public class FavorServiceImpl extends ServiceImpl<FavorMapper, Favor> implements FavorService {
  @Override
  @Transactional(readOnly = true)
  public List<FavorVo> listFavor() {
    return baseMapper.selectFavor();
  }
}

