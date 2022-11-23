package com.sx.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.common.mapStruct.MapStructs;
import com.sx.common.util.JsonVos;
import com.sx.pojo.po.Chat;
import com.sx.pojo.vo.PageJsonVo;
import com.sx.pojo.vo.list.ChatVo;
import com.sx.pojo.vo.req.page.ChatsPageReqVo;
import com.sx.pojo.vo.req.save.ChatReqVo;
import com.sx.service.ChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping("/chats")
@Api(tags = "聊天记录")
public class ChatController extends BaseController<Chat, ChatReqVo> {
  @Autowired
  private ChatService service;

  @GetMapping
  @ApiOperation("分页查询")
  public PageJsonVo<ChatVo> list(ChatsPageReqVo reqVo) {
    return JsonVos.ok(service.list(reqVo));
  }

  @Override
  protected IService<Chat> getService() {
    return service;
  }

  @Override
  protected Function<ChatReqVo, Chat> getFunction() {
    return MapStructs.INSTANCE::reqVo2po;
  }
}

