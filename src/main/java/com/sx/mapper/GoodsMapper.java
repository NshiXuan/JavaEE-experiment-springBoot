package com.sx.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.sx.common.enhance.MyLambdaQueryWrapper;
import com.sx.common.enhance.MyPage;
import com.sx.pojo.po.Goods;
import com.sx.pojo.vo.list.GoodsVo;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper extends BaseMapper<Goods> {

}
