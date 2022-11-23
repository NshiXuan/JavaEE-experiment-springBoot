package com.sx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sx.pojo.po.Favor;
import com.sx.pojo.vo.list.FavorVo;

import java.util.List;

public interface FavorMapper extends BaseMapper<Favor> {
  List<FavorVo> selectFavor();
}
