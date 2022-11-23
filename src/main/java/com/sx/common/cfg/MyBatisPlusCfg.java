package com.sx.common.cfg;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sx.mapper") // 扫描mapper放在找不到mapper的bean，把mapper放到容器中
public class MyBatisPlusCfg {
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    PaginationInnerInterceptor innerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
    // 当页数超过总页数时，自动跳回到第1页
    innerInterceptor.setOverflow(true);
    interceptor.addInnerInterceptor(innerInterceptor);
    return interceptor;
  }

  @Bean
  public ConfigurationCustomizer configurationCustomizer() {
    return configuration -> configuration.setUseDeprecatedExecutor(false);
  }
}
