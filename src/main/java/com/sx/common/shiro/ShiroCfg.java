package com.sx.common.shiro;

import com.sx.filter.ErrorFilter;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroCfg {
  @Bean
  public Realm realm() {
    return new TokenRealm(new TokenMatcher());
  }

  /**
   * ShiroFilterFactoryBean用来告诉Shiro如何进行拦截
   * 1.拦截哪些URL
   * 2.每个URL需要进行哪些filter
   */
  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(Realm realm) {
    ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();

    // 安全管理器
    filterFactoryBean.setSecurityManager(new DefaultWebSecurityManager(realm));

    // 添加一下自定义Filter
    Map<String, Filter> filters = new HashMap<>();
    filters.put("token", new TokenFilter());
    filterFactoryBean.setFilters(filters);

    // 设置URL如何拦截 LinkedHashMap保持添加顺序 越靠前越优先匹配
    Map<String, String> urlMap = new LinkedHashMap<>();
    // anon为匿名访问 相当于谁都可以访问
    // 验证码
    urlMap.put("/users/captcha", "anon");
    // 用户登录
    urlMap.put("/users/login", "anon");
    // 开发swagger
    urlMap.put("/swagger*/**", "anon");
    urlMap.put("/v2/api-docs/**", "anon");
    // 全局Filter的异常处理
    urlMap.put(ErrorFilter.ERROR_URL, "anon");

    // 其它
    // urlMap.put("/**", "anon");
    urlMap.put("/**", "token");
    filterFactoryBean.setFilterChainDefinitionMap(urlMap);


    return filterFactoryBean;
  }
}
