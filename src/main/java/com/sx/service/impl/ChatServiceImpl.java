package com.sx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sx.common.enhance.MyPage;
import com.sx.common.enhance.MyQueryWrapper;
import com.sx.mapper.ChatMapper;
import com.sx.pojo.po.Chat;
import com.sx.pojo.vo.PageVo;
import com.sx.pojo.vo.list.ChatVo;
import com.sx.pojo.vo.req.page.ChatsPageReqVo;
import com.sx.service.ChatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("chatService")
@Transactional
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements ChatService {
  @Override
  @Transactional(readOnly = true)
  public PageVo<ChatVo> list(ChatsPageReqVo reqVo) {
    MyQueryWrapper<ChatVo> wrapper = new MyQueryWrapper<>();
    return baseMapper.selectPageVos(new MyPage<>(reqVo), wrapper).buildVo();
  }
}

