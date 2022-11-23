package com.sx.common.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sx.common.util.Streams;
import com.sx.pojo.vo.PageVo;
import com.sx.pojo.vo.req.page.PageReqVo;

import java.util.List;
import java.util.function.Function;

public class MyPage<T> extends Page<T> {
  private final PageReqVo reqVo;

  public MyPage(PageReqVo reqVo) {
    super(reqVo.getPage(), reqVo.getSize());
    this.reqVo = reqVo;
  }

  private <N> PageVo<N> commonBuildVo(List<N> data) {
    reqVo.setPage(getCurrent());
    reqVo.setSize(getSize());

    PageVo<N> pageVo = new PageVo<>();
    pageVo.setTotal(getTotal());
    pageVo.setPages(getPages());
    pageVo.setData(data);
    return pageVo;
  }

  public PageVo<T> buildVo() {
    return commonBuildVo(getRecords());
  }

  public <R> PageVo<R> buildVo(Function<T, R> function) {
    return commonBuildVo(Streams.map(getRecords(), function));
  }
}
