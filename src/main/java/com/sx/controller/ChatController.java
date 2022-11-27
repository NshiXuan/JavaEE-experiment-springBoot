package com.sx.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sx.common.mapStruct.MapStructs;
import com.sx.common.util.Constants;
import com.sx.common.util.JsonVos;
import com.sx.pojo.po.Chat;
import com.sx.pojo.vo.JsonVo;
import com.sx.pojo.vo.PageJsonVo;
import com.sx.pojo.vo.list.ChatVo;
import com.sx.pojo.vo.req.page.ChatsPageReqVo;
import com.sx.pojo.vo.req.save.ChatReqVo;
import com.sx.service.ChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.function.Function;

@RestController
@RequestMapping("/chats")
@Api(tags = "聊天记录")
public class ChatController extends BaseController<Chat, ChatReqVo> {
  @Autowired
  private ChatService service;

  @GetMapping
  @ApiOperation("分页查询")
  @RequiresPermissions(Constants.Permisson.CHAT_LIST)
  public PageJsonVo<ChatVo> list(ChatsPageReqVo reqVo) {
    return JsonVos.ok(service.list(reqVo));
  }

  @Override
  @RequiresPermissions(value = {
          Constants.Permisson.CHAT_ADD,
          Constants.Permisson.CHAT_UPDATE
  }, logical = Logical.OR)
  public JsonVo save(@RequestBody ChatReqVo reqVo) {
    return super.save(reqVo);
  }

  @Override
  @RequiresPermissions(Constants.Permisson.CHAT_REMOVE)
  public JsonVo remove(String id) {
    return super.remove(id);
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

