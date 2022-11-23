package com.sx.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.sx.common.enhance.MyLambdaQueryWrapper;
import com.sx.common.enhance.MyPage;
import com.sx.pojo.po.Chat;
import com.sx.pojo.vo.list.ChatVo;
import org.apache.ibatis.annotations.Param;

public interface ChatMapper extends BaseMapper<Chat> {
  MyPage<ChatVo> selectPageVos(MyPage<ChatVo> page, @Param(Constants.WRAPPER) Wrapper<ChatVo> wrapper);
}
