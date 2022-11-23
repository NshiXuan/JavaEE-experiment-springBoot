package com.sx.common.shiro;

import com.sx.common.cache.Caches;
import com.sx.common.util.JsonVos;
import com.sx.pojo.result.CodeMsg;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/* 作用：验证用户的合法性、是否有相关权限*/
public class TokenFilter extends AccessControlFilter {
  public static final String HEADER_TOKEN = "Token";

  /**
   * 当请求被TokenFilter拦截时，会调用这个方法
   * 可以在这个方法中做初步判断
   * <p>
   * 如果返回true: 允许访问，可以进入下一个链条调用（比如Filter、拦截器、控制器等）
   * 如果返回false: 不允许访问，会进入下面的onAccessDenied方法，不进入下一个链条
   */
  @Override
  protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    // 放行所有的OPTIONS请求
    // return "POTIONS".equals(request.getMethod());
    return false;
  }

  /**
   * 当isAccessAllowed返回false时会调用这个方法
   * 在这个方法进行token校验
   * <p>
   * 如果返回true: 允许访问，可以进入下一个链条调用（比如Filter、拦截器、控制器等）
   * 如果返回false: 不允许访问，不进入下一个链条
   */
  @Override
  protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
    HttpServletRequest request = (HttpServletRequest) servletRequest;

    // 取出Token
    String token = request.getHeader("Token");
    // System.out.println("token" + token);

    // 如果没有token
    if (token == null) {
      return JsonVos.raise(CodeMsg.NO_TOKEN);
    }

    // 如果token过期
    if (Caches.getToken(token) == null) {
      return JsonVos.raise(CodeMsg.TOKEN_EXPIRED);
    }

    // TODO 鉴权

    return true;
  }
}
