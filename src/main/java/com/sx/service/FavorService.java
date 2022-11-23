package com.sx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.pojo.po.Favor;
import com.sx.pojo.vo.list.FavorVo;

import java.util.List;

public interface FavorService extends IService<Favor> {
  List<FavorVo> listFavor();
}

