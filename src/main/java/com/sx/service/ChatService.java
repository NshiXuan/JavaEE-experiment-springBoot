package com.sx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.pojo.po.Chat;
import com.sx.pojo.vo.PageVo;
import com.sx.pojo.vo.list.ChatVo;
import com.sx.pojo.vo.req.page.ChatsPageReqVo;

public interface ChatService extends IService<Chat> {
  PageVo<ChatVo> list(ChatsPageReqVo reqVo);
}

