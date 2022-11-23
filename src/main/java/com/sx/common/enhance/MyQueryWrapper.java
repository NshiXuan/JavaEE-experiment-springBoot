package com.sx.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public class MyQueryWrapper<T> extends QueryWrapper<T> {
  @SafeVarargs
  public final MyQueryWrapper<T> like(Object val, String... columns) {
    if (val == null) return this;
    String str = val.toString();
    if (str.length() == 0) return this;
    return (MyQueryWrapper<T>) nested((w) -> {
      for (String column : columns) {
        w.like(column, str).or();
      }
    });
  }
}
