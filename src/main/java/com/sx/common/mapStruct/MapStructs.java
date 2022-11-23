package com.sx.common.mapStruct;

import com.sx.pojo.po.Chat;
import com.sx.pojo.po.Favor;
import com.sx.pojo.po.Goods;
import com.sx.pojo.po.Users;
import com.sx.pojo.vo.LoginVo;
import com.sx.pojo.vo.list.ChatVo;
import com.sx.pojo.vo.list.FavorVo;
import com.sx.pojo.vo.list.GoodsVo;
import com.sx.pojo.vo.list.UsersVo;
import com.sx.pojo.vo.req.save.ChatReqVo;
import com.sx.pojo.vo.req.save.FavorReqVo;
import com.sx.pojo.vo.req.save.GoodsReqVo;
import com.sx.pojo.vo.req.save.UsersReqVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructs {
  MapStructs INSTANCE = Mappers.getMapper(MapStructs.class);

  /* Po -> Vo*/
  GoodsVo po2vo(Goods po);

  LoginVo po2loginVo(Users po);

  /* ReqVo -> Po */
  Chat reqVo2po(ChatReqVo reqVo);

  Favor reqVo2po(FavorReqVo reqVo);

  Goods reqVo2po(GoodsReqVo reqVo);

  Users reqVo2po(UsersReqVo reqVo);
}
