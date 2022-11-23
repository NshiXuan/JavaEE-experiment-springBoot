package com.sx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.pojo.po.Goods;
import com.sx.pojo.vo.PageVo;
import com.sx.pojo.vo.list.GoodsVo;
import com.sx.pojo.vo.req.page.GoodsPageReqVo;

public interface GoodsService extends IService<Goods> {

  PageVo<GoodsVo> list(GoodsPageReqVo reqVo);
}

