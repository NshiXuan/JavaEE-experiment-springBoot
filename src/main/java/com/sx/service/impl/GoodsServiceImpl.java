package com.sx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sx.common.enhance.MyLambdaQueryWrapper;
import com.sx.common.enhance.MyPage;
import com.sx.common.mapStruct.MapStructs;
import com.sx.mapper.GoodsMapper;
import com.sx.pojo.po.Goods;
import com.sx.pojo.vo.PageVo;
import com.sx.pojo.vo.list.GoodsVo;
import com.sx.pojo.vo.req.page.GoodsPageReqVo;
import com.sx.pojo.vo.req.save.GoodsReqVo;
import com.sx.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.function.Function;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

  @Override
  @Transactional(readOnly = true)
  public PageVo<GoodsVo> list(GoodsPageReqVo reqVo) {
    MyLambdaQueryWrapper<Goods> wrapper = new MyLambdaQueryWrapper<>();
    wrapper.like(reqVo.getKeyword(), Goods::getGoodName);


    return baseMapper.selectPage(new MyPage<>(reqVo), wrapper).buildVo(MapStructs.INSTANCE::po2vo);
  }

}

